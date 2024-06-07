package br.com.fiap.erik_93599
import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.erik_93599.ui.theme.Erik_93599Theme

class MainActivity : AppCompatActivity() {

    private lateinit var ItemAdapter: ItemAdapter
    private val listaPraia = mutableListOf<Praia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val nomePraia: EditText = findViewById(R.id.editNomePraia)
        val nomeCidade: EditText = findViewById(R.id.editNomeCidade)
        val nomeEstado: EditText = findViewById(R.id.editNomeEstado)
        val btnAdd: Button = findViewById(R.id.buttonAdicionar)

        ItemAdapter = ItemAdapter(listaPraia) { praia -> listaPraia.remove(praia)
            ItemAdapter.notifyDataSetChanged()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter

        btnAdd.setOnClickListener {
            val nome = nomePraia.text.toString().trim()
            val cidade = nomeCidade.text.toString().trim()
            val estado = nomeEstado.text.toString().trim()

            if (nome.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else if (nome.length < 3 || cidade.length < 3 || estado.length < 2) {
                Toast.makeText(this, "Verifique os tamanhos mínimos dos campos", Toast.LENGTH_SHORT).show()
            } else {
                val beach = Praia(nome, cidade, estado)
                listaPraia.add(beach)
                ItemAdapter.notifyDataSetChanged()
                nomePraia.text.clear()
                nomeCidade.text.clear()
                nomeEstado.text.clear()
            }
        }
    }

   /* private fun findViewById(recyclerView: Int): RecyclerView {

    }

    private fun setContentView(activityMain: Int) {

    }*/
}