package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailBienvenida(String receiverEmail, String nombre) {
        SimpleMailMessage message = new SimpleMailMessage();

        String titulo = "¡Bienvenido a EzLink!";
        String mensaje = "Hola " + nombre.toUpperCase() +"!" +
                    "\n\nGracias por registrarte a EzLink. Apreciamos tu interés por este proyecto." +
                    "\n\nNuestra intención es brindarte el mejor servicio posible, asi que por favor no dudes en comunicarte con nosotros (ignora el .noreply). Queremos esuchar tus comentarios." +
                    "\n\nSin nada más que decirte, disfruta de EzLink y por favor no dudes en recomendarnos (y donar :D )." +
                    "\n\nTe deseamos todo lo mejor," +
                    "\nProyecto EzLink";

        message.setFrom("ezlink.noreply@gmail.com");
        message.setTo(receiverEmail);
        message.setText(mensaje);
        message.setSubject(titulo);
        mailSender.send(message);
        System.out.println("Correo enviado...");
    }
}
