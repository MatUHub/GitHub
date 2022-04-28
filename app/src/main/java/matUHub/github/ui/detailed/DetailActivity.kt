package matUHub.github.ui.detailed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import matUHub.github.databinding.ActivityDetailBinding
import matUHub.github.domain.GitProjectEntity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<GitProjectEntity>("user")
        if (user != null) {
            val idUser: TextView = binding.itemIdTextView
            val nameUser: TextView = binding.itemNameTextView
            val imageUser: ImageView = binding.itemImageView

            idUser.text = user.id.toString()
            nameUser.text = user.name
            imageUser.setImageResource(user.image)
        }
    }
}