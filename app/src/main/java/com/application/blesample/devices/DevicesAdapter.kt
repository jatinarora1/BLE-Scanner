package com.application.blesample.devices
import android.bluetooth.BluetoothDevice
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.application.blesample.R
import com.application.blesample.extensions.inflate
import kotlinx.android.synthetic.main.adapter_devices.view.*

class DevicesAdapter : RecyclerView.Adapter<DevicesAdapter.ViewHolder>() {

    private val devices = ArrayList<BluetoothDevice>()

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int) = ViewHolder(
        container.inflate(R.layout.adapter_devices)
    )

    override fun getItemCount() = devices.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(devices[position])
        viewHolder.itemView.tag = devices[position];
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    fun addDevice(device: BluetoothDevice) {
        if(device !in devices)
            devices.add(device)
        notifyDataSetChanged()
    }

    fun clearDevices() {
        devices.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(device: BluetoothDevice) {
            view.text_view_device_name.text = device.name ?: device.address

        }
    }
}