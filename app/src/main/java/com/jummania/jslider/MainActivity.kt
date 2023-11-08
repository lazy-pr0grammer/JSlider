package com.jummania.jslider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.jummania.jslider.animations.AnimationTypes
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var arraylist: ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jSlider: JSlider = findViewById(R.id.jSlider)
        createList()
        jSlider.setSlideAnimation(AnimationTypes.DEPTH_SLIDE)
        jSlider.setSlider(Slider())
    }

    private inner class Slider : JSlider.Slide() {
        override fun getView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
            return layoutInflater.inflate(R.layout.item_slider, parent, false)
        }

        override fun onSliderCreate(view: View, position: Int) {

            val list = arraylist[position]

            val imageView: AppCompatImageView = view.findViewById(R.id.imageView)

            Picasso.get().load(list.photo).placeholder(R.drawable.default_loading)
                .error(R.drawable.default_error).into(imageView)

            view.setOnClickListener {
                Toast.makeText(this@MainActivity, list.name, Toast.LENGTH_SHORT).show()
            }
        }

        override fun getCount(): Int {
            return arraylist.size
        }

    }

    private fun createList() {
        arraylist = arrayListOf()

        arraylist.add(
            Data(
                "AR Sharif Uddin Jumman",
                "https://jummania.com/App/BanglaNatokSamahar/Images/Cover%20Photo.jpg"
            )
        )

        arraylist.add(
            Data(
                "Anindya Das", "https://jummania.com/App/BanglaNatokSamahar/Images/Aninda das.jpg"
            )
        )
        arraylist.add(
            Data(
                "MD Abdullah", "https://avatars.githubusercontent.com/u/110069678?v=4"
            )
        )

        arraylist.add(
            Data(
                "Sharif Uddin Jumman",
                "https://jummania.com/App/BanglaNatokSamahar/Images/profile%20circle.jpg"
            )
        )

        arraylist.add(
            Data(
                "MD Sarowar Hosain Shuvo",
                "https://scontent.fdac142-1.fna.fbcdn.net/v/t1.6435-9/120902465_785023465615624_7635398377734730401_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=be3454&_nc_ohc=azvmlXXjIDEAX8eil0Z&_nc_ht=scontent.fdac142-1.fna&oh=00_AfCRLl3dlz8aqhEmHWqEUtaUcvq65g2gdx67Nlr0IsTttA&oe=6550B2AD"
            )
        )
        arraylist.add(
            Data(
                "Sharif Uddin Jumman",
                "https://jummania.com/App/BanglaNatokSamahar/Images/Profile%20Photo.jpg"
            )
        )

    }
}