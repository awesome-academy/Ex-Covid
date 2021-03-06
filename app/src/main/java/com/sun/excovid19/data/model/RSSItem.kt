package com.sun.excovid19.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.sun.excovid19.utils.AppConstant
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Parcelize
@Root(name = "item", strict = false)
data class RSSItem(
    @field:Element(name = "title")
    var title: String,
    @field:Element(name = "description")
    var description: String,
    @field:Element(name = "pubDate")
    var pubDate: String,
    @field:Element(name = "link")
    var link: String
) : Parcelable {

    //Use default no arg constructor for SimpleXmlConverter.
    constructor() : this(
        AppConstant.DEFAULT_LABEL,
        AppConstant.DEFAULT_LABEL,
        AppConstant.DEFAULT_LABEL,
        AppConstant.DEFAULT_LABEL
    )

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RSSItem>() {
            override fun areItemsTheSame(oldItem: RSSItem, newItem: RSSItem) =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: RSSItem, newItem: RSSItem) = oldItem == newItem
        }
    }
}
