package ali.ghanbariyan.goldproject.activity

import ali.ghanbariyan.goldproject.databinding.ActivityLauncherActivityBinding
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLauncherActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  //start main_Activity activity


            finish()  //close Splash_Screen then (5s)

        }, 5000)

    }
}