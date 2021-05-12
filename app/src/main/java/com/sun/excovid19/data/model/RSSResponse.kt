package com.sun.excovid19.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class RSSResponse(
    @field:Element(name = "channel")
    var channel: RSSChannel?
) {

    //Use default no arg constructor for SimpleXmlConverter.
    constructor() : this(null)
}
