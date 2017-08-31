package com.zyyoona7.kextensions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.DateUtils
import com.zyyoona7.lib.*
import java.io.File

class MainActivity : AppCompatActivity() {
    val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logEnabled(true)
//        logGlobalTag("GlobalTag")
//        logv("Hello")
//        logd("Hello", customTag = "customTag")
//        logi("Hello")
//        logw("Hello")
//        loge("Hello")
//        val json = """         {'name':'zyyoona7','age':'20'}   """
//        logJson(json)
//
//        loge(fileDirPath)
//        loge(cacheDirPath)
//        loge(externalFileDirPath)
//        loge(externalCacheDirPath)
//
        loge("dir exist ${isDirExists(externalFileDirPath)}")

        loge("dir exist ${isDirExists(externalFileDirPath + "/a")}")

        loge(getDirSize(publicDownloadDir))
        loge(getDirSize(publicDCIMDir))
        loge(getDirSize(publicPictureDir))
        loge(getDirSize(publicMusicDir))
        loge(getDirSize(publicMovieDir))

        val download = publicDownloadDir + "/a.txt"
        loge("path=$download \nDir=${getDirName(download)}")
        loge("path=$download \nFile=${getFileName(download)}")

        val content = """a
            |a
            |a
            |a
            |s
            |d
            |d
            |f
        """.trimMargin()
        writeStringAsFile(download, content)

        loge(readFileAsString(download))
        val destFilePath = publicPictureDir + "/b.txt"
        createOrExistsFile(destFilePath)
        loge("copy finished ${copyOrMoveFile(download, destFilePath, true)}")
    }
}
