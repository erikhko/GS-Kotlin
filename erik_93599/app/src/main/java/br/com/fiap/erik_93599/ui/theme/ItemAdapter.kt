package br.com.fiap.erik_93599

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class Praia(val nome: String, val cidade: String, val estado: String)

class ItemAdapter(
    private val itemList: MutableList<Praia>,
    private val onRemoveClick: (Praia) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item, onRemoveClick)
    }

    override fun getItemCount(): Int = itemList.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewNomePraia)
        private val cityTextView: TextView = itemView.findViewById(R.id.textViewNomeCidade)
        private val stateTextView: TextView = itemView.findViewById(R.id.textViewNomeEstado)
        /*private val removeButton: ImageButton = itemView.findViewById(R.id.buttonRemove)*/

        fun bind(item: Praia, onRemoveClick: (Praia) -> Unit) {
            nameTextView.text = item.nome
            cityTextView.text = item.cidade
            stateTextView.text = item.estado
            /*removeButton.setOnClickListener {
                onRemoveClick(item)
            }*/
        }
    }
}
