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

        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.END_TAG -> {
                    if (parser.name == "libraryinfo") {
                        libraryList.add(Library(
                            parser.getAttributeValue(0),
                            parser.getAttributeValue(1)
                        ))
                    }
                }
            }

            eventType = parser.next()
        }

        return libraryList
    }
}