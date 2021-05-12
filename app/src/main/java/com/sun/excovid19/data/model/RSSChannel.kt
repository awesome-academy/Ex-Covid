package com.sun.excovid19.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class RSSChannel(
    @field:ElementList(name = "item", inline = true)
    var item: MutableList<RSSItem>?
) {

    //Use default no arg constructor for SimpleXmlConverter.
    constructor() : this(null)
}
