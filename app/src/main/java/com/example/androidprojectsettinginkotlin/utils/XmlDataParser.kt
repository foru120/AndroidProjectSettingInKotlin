package com.example.androidprojectsettinginkotlin.utils

import com.example.androidprojectsettinginkotlin.data.vo.Library
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

class XmlDataParser {
    val parserFactory = XmlPullParserFactory.newInstance()
    val parser = parserFactory.newPullParser()

    fun getLibraryXml(inputStream: InputStream): ArrayList<Library> {
        parser.setInput(inputStream, "UTF-8")

        var eventType = parser.eventType
        val libraryList = arrayListOf<Library>()
        var library: Library? = null

        while (eventType != XmlPullParser.END_DOCUMENT) {
            var tagName: String? = null

            when (eventType) {
                XmlPullParser.START_TAG -> {
                    library = if (parser.name == "library") Library() else null
                }
                XmlPullParser.END_TAG -> {
                    if (parser.name == "library") library?.let { libraryList.add(it) }
                }
                XmlPullParser.TEXT -> {
                    when (parser.name) {
                        "name" -> library?.let { it.name = parser.text }
                        "url" -> library?.let { it.url = parser.text }
                    }
                }
            }

            parser.next()
        }

        return libraryList
    }
}