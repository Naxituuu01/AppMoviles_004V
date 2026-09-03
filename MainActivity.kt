package com.duoc.perfil

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duoc.perfil.ui.theme.PerfilTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerfilTheme {
                PantallaPerfil()
            }
        }
    }
}

@Composable
fun PantallaPerfil(){

    //Estados editables
    var nombre by remember{mutableStateOf(TextFieldValue("Ignacio Retamales")) }
    var correo by remember{mutableStateOf(TextFieldValue("i.retamales@duocuc.cl")) }
    var bio by remember{mutableStateOf(TextFieldValue("Alumno de Duoc UC")) }
    var guardar by remember {mutableStateOf(false)}

    //Contenedor
    Surface(
        modifier = Modifier
            .fillMaxSize(),
            color = Color(0xFFF3F4F6)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.laroca),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)//Circulo perfecto
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Text("Mi perfil", fontSize = 24.sp, color = Color(0xFF1E88E5))

            //Linea divisora horizontal
            //HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

            //Campos editables
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            //Correo
            //Campos editables
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            //bio
            //Campos editables
            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text("Biografia") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            //Boton de guardar
            Button(
                onClick = {guardar = true},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107),
                    contentColor = Color.Black
                )
            )

            { Text("Guardar cambios") }

            //
            if(guardar){
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Cambios guardados correctamente",
                    color = Color(0xFF2E7D32),
                    fontSize = 16.sp)
            }
        }
    }
}

@Preview
@Composable
fun PantallaPerfilPreview(){
    PerfilTheme {
        PantallaPerfil()
    }
}