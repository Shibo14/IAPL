package khan.uz.iapl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import khan.uz.iapl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listData: ArrayList<InfoData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageInfo = intArrayOf(
            R.drawable.logo_java,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,


            )
        val titleInfo = arrayOf(
            "Java",
            "Python",
            "C"
        )
        val info = arrayOf(
            "Java dunyoda eng mashxur dasturlash tillaridan bittasi.\n" +
                    "Java - yirik tashkilotlarning yana bir mashhur tanlovidir va u o'nlab yillar davomida shunday bo'lib kelgan.",
            "Dasturlashni endi o'rganishni boshlaganlar uchun eng yaxshi dasturlash tili sifatida keng tarqalgan.\n" +
                    "Python tez, oson ishlatiladigan va joylashtirilishi oson dasturiy til bo'lib, " +
                    "kengaytiriladigan veb-ilovalarni ishlab chiqishda keng qo'llaniladi.",
            "C"


        )



        listData = ArrayList()
        for (i in titleInfo.indices) {
            val data = InfoData(titleInfo[i], info[i], imageInfo[i])
            listData.add(data)
        }
        binding.listView.isClickable = true
        binding.listView.adapter = Adapter(this, listData)

        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val titleDialog = titleInfo[position]
            val infoDialog = info[position]
            val imageDialog = imageInfo[position]

            val myDialog = LayoutInflater.from(this).inflate(R.layout.info_dialog, null)

            val dialog = AlertDialog.Builder(this).setView(myDialog)


            val dialogName = myDialog.findViewById(R.id.dialog_title) as TextView
            val dialogInfo = myDialog.findViewById(R.id.dialog_info) as TextView
            val dialogImage = myDialog.findViewById(R.id.dialog_img) as ImageView

            dialogName.text = titleDialog
            dialogInfo.text = infoDialog
            dialogImage.setImageResource(imageDialog)

            dialog.create()
            dialog.show()




        }


    }

}