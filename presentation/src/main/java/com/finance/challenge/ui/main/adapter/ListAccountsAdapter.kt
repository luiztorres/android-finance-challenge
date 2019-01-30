package com.finance.challenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.finance.challenge.challenge.R
import com.finance.challenge.domain.model.AccountViewModel
import kotlinx.android.synthetic.main.item_list_account.view.*

class ListAccountsAdapter(private val listAccountClickListener: ListAccountClickListener) : RecyclerView.Adapter<ListAccountsAdapter.ListAccountViewHolder>() {

    private var accountViewModelList: List<AccountViewModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAccountViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_account, parent, false)

        return ListAccountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return accountViewModelList.size
    }

    override fun onBindViewHolder(holder: ListAccountViewHolder, position: Int) {
        val account = accountViewModelList[position]

        holder.name.text = account.name
        holder.amount.text = account.formattedAmount

        holder.itemView.setOnClickListener {
            listAccountClickListener.onAccountClick(account)
        }
    }

    fun setAccountViewModelList(accountViewModelList: List<AccountViewModel>) {
        this.accountViewModelList = accountViewModelList

        notifyDataSetChanged()
    }

    class ListAccountViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.item_list_account_name
        val amount: TextView = view.item_list_account_amount
    }
}