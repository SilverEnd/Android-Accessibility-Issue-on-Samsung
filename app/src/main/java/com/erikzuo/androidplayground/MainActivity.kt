package com.erikzuo.androidplayground

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.erikzuo.androidplayground.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding

    private val testFileName = "test.txt"
    private val testFileDirectory: File = File("${Environment.getExternalStorageDirectory().absolutePath}/Test/debug")
    private val testFile: File = File(testFileDirectory, testFileName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        requestExternalStoragePermissionIfNeeded()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE -> {
                if (ContextCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
                    saveFile()
                }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    private fun requestExternalStoragePermissionIfNeeded() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE
        )
    }

    private fun saveFile() {
        if (!testFile.exists()) {
            testFileDirectory.mkdirs()
            testFile.createNewFile()
        }

        try {
            FileOutputStream(testFile).run {
                write("test".toByteArray())
                flush()
                close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 100
    }
}