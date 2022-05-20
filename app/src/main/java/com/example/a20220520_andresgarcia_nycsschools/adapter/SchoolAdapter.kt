package com.example.a20220520_andresgarcia_nycsschools.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220520_andresgarcia_nycsschools.databinding.SchoolItemBinding
import com.example.a20220520_andresgarcia_nycsschools.model.Schools

class SchoolAdapter (
    private var schoolList:MutableList<Schools> = mutableListOf(),
    private var openSchool:(Schools) -> Unit
    ): RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(SchoolItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(schoolList[position],openSchool)
        }

        override fun getItemCount(): Int = schoolList.size

        fun update(schools:List<Schools>){
            schoolList.clear()
            schoolList.addAll(schools)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
        private val binding:SchoolItemBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(schoolItem:Schools,openSchool: (Schools) -> Unit){
            binding.tvSchoolName.text =  schoolItem.schoolName
            binding.tvCity.text = "City:  ${schoolItem.city}"
            binding.tvZip.text = "Zip:  ${schoolItem.zip}"
            binding.tvPhoneNumber.text = "Phone:  ${schoolItem.location}"
            itemView.setOnClickListener { openSchool(schoolItem) }
        }
}