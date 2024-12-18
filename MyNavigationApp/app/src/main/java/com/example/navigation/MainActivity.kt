//package com.example.navigation
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
// android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.navigation.ui.theme.MyNavigationAppTheme
//
////class MainActivity : ComponentActivity() {
//class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//    private lateinit var mMap: GoogleMap
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // SupportMapFragment를 찾아서 초기화
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//    }
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // 유성온천공원 위치에 마커 추가
//        val startLocation = LatLng(36.3624, 127.3348) // 유성온천공원
//        val endLocation = LatLng(36.3577, 127.3449) // 궁동119안전센터
//
//        // 마커 추가
//        mMap.addMarker(MarkerOptions().position(startLocation).title("출발지: 유성온천공원"))
//        mMap.addMarker(MarkerOptions().position(endLocation).title("도착지: 궁동119안전센터"))
//
//        // 카메라를 출발지로 이동
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 15f))
//    }
//}
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyNavigationAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyNavigationAppTheme {
//        Greeting("Android")
//    }
//}
// ------------------2--------------------
//package com.example.navigation
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // activity_main.xml 연결
//    }
//}

//---------맵 실행 위해 변경 ------------
//package com.example.navigation
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//
//class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//
//    private lateinit var mMap: GoogleMap
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Google Map Fragment 가져오기
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // 유성온천공원과 궁동119안전센터 마커 추가
//        val startLocation = LatLng(36.3624, 127.3348) // 유성온천공원
//        val endLocation = LatLng(36.3577, 127.3449) // 궁동119안전센터
//
//        // 마커 추가
//        mMap.addMarker(MarkerOptions().position(startLocation).title("출발지: 유성온천공원"))
//        mMap.addMarker(MarkerOptions().position(endLocation).title("도착지: 궁동119안전센터"))
//
//        // 카메라를 출발지로 이동
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 15f))
//    }
//}
//

package com.example.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MapView 초기화
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)  // 지도가 준비되면 onMapReady 호출
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        // 지도에 마커 추가
        val startLocation = LatLng(36.3624, 127.3348)  // 예시 좌표
        googleMap.addMarker(MarkerOptions().position(startLocation).title("유성온천공원"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 15f)) // 카메라 위치 설정
    }

    // MapView 라이프사이클 관리
    override fun onResume() {
        super.onResume()
        mapView.onResume() // 맵 뷰를 다시 활성화
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause() // 맵 뷰를 일시 정지
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy() // 맵 뷰 해제
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory() // 메모리 부족 시 맵 뷰 처리
    }
}
