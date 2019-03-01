package br.com.caelum.twittelumappweb.fragment

import android.Manifest
import android.arch.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.GPS
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaFragment : SupportMapFragment() {
    val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        getMapAsync {googleMap ->

            val tweets = viewModel.tweets().value

//            tweets?.forEach { tweet ->
//
//
//
//
//                val marcador = MarkerOptions()
//
//
//                marcador.position(LatLng(tweet.latitude, tweet.longitude))
//                marcador.title(tweet.mensagem)
//
//            }

            val gps = GPS(activity?.baseContext!!)
            gps.fazBusca()
            val (lat, lng) = gps.getCoordenadasAtuais()

            val marcador = MarkerOptions()
            val latLng = LatLng(lat, lng)
            marcador.position(latLng)
            marcador.title("oi")
            googleMap.addMarker(marcador)

            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 7F)
            googleMap.moveCamera(cameraUpdate)

        }
    }
}
