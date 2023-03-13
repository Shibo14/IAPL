package khan.uz.iapl

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(var context: Activity, var listInfo: ArrayList<InfoData>) :
    ArrayAdapter<InfoData>(context, R.layout.list_item, listInfo) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)

        val image: ImageView = view.findViewById(R.id.item_image)
        val textTitle: TextView = view.findViewById(R.id.item_text)

        image.setImageResource(listInfo[position].image)
        textTitle.text = listInfo[position].name





        return view
    }


}