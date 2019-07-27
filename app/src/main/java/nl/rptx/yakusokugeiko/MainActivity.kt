package nl.rptx.yakusokugeiko

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import nl.rptx.yakusokugeiko.repositories.readTechniques
import nl.rptx.yakusokugeiko.tasks.createState

class MainActivity : AppCompatActivity(), TechniqueFragment.OnFragmentInteractionListener {
    private lateinit var state: YakuSokuGeikoState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        offensiveTechnique().setLabel("Attack")
        defensiveTechnique().setLabel("Defense")

        val techniques = readTechniques(resources)
        this.state = createState(techniques)
        getNext()

        fab.setOnClickListener {
            getNext()
        }
    }

    private fun getNext() {
        var assignment = state.getNext()

        offensiveTechnique().setTechnique(assignment.attack)
        defensiveTechnique().setTechnique(assignment.defense)
    }

    private fun defensiveTechnique() = (frag_defense as TechniqueFragment)

    private fun offensiveTechnique() = (frag_attack as TechniqueFragment)

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}

