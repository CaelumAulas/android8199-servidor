package br.com.caelum.twittelumappweb

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

class GPS(context: Context) : LocationCallback() {
    val request = LocationRequest()
    var location: LocationResult? = null

    var client = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun fazBusca() {

        request.apply {
            interval = 2000
            smallestDisplacement = 5.0f
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        client.requestLocationUpdates(request, this, null)
    }


    fun getCoordenadasAtuais(): Pair<Double, Double> {
        val lastLocation = location?.lastLocation

        val latitude = lastLocation?.latitude
        val longitude = lastLocation?.longitude

        return Pair(latitude?: 0.0, longitude?: 0.0)
    }

    override fun onLocationResult(locationResult: LocationResult?) {
        super.onLocationResult(locationResult)

        location = locationResult
    }
}