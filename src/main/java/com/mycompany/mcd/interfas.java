package com.mycompany.mcd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class interfas extends JFrame implements ActionListener{
	
    JFrame marco=new JFrame();
    JButton boton = new JButton("CALCULAR");
    JLabel Cantidad = new JLabel("¿Cuantos números evaluara?");
    JLabel Numeros = new JLabel("Digite los numeros separados por ',':");
    JLabel Error = new JLabel();
    JLabel imagen = new JLabel();
    JLabel Propietario = new JLabel("Kevin Santiago Ramírez Montoya");
    JTextField Num = new JTextField();
    JTextField Cant = new JTextField();
    JTextArea proceso1 = new JTextArea();
    JTextArea proceso2 = new JTextArea();
    JTextArea proceso3 = new JTextArea();
    JScrollPane scroll1 = new JScrollPane (proceso1);
    JScrollPane scroll2 = new JScrollPane (proceso2);
    JScrollPane scroll3 = new JScrollPane (proceso3);
    String mensaje1="";
    String mensaje2="";
    String mensaje3="";
    int y[];
    int x;
    Icon Imagen = new ImageIcon("C:\\Users\\kerwi\\OneDrive\\Documentos\\NetBeansProjects\\MCD\\src\\main\\java\\com\\mycompany\\imagen\\operacion.png");

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            limpiar();
            int x;
            x=obtener();
            if(x!=0) {
                calcular(x-1);
                escribir();
            }
        }
    }

    interfas(){

        marco.getContentPane().setBackground(new Color(133, 218, 141));
        marco.setTitle("MCD");
        marco.setSize(490,670);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(null);

        marco.add(boton);
        boton.setBounds(190,110,100,30);
        boton.setBackground(new Color(76, 109, 219));
        boton.addActionListener(this);
        marco.add(Cantidad);
        Cantidad.setBounds(30,30,180,25);
        Cantidad.setForeground(new Color(0, 72, 255));
        marco.add(Numeros);
        Numeros.setBounds(30,70,230,25);
        Numeros.setForeground(new Color(0, 72, 255));
        marco.add(Cant);
        Cant.setBounds(210,30,30,25);
        Cant.setBackground(new Color(56, 139, 140));		
        marco.add(Num);
        Num.setBounds(250,70,190,25);
        Num.setBackground(new Color(56, 139, 140));
        marco.add(Error);
        Error.setBounds(250,30,250,25);
        Error.setForeground(new Color(124, 14, 14));
        marco.add(Propietario);
        Propietario.setBounds(30,590,200,25);
        Propietario.setBackground(Color.black);
        scroll1.setBounds(30,170,200,200);
        proceso1.setBackground(new Color(255, 215, 134));
        marco.add(scroll1);
        scroll2.setBounds(30,380,200,200);
        proceso2.setBackground(new Color(255, 138, 134));
        marco.add(scroll2);
        scroll3.setBounds(240,170,200,200);
        proceso3.setBackground(new Color(134, 255, 244));
        marco.add(scroll3);
        proceso1.setEditable(false);
        proceso2.setEditable(false);
        proceso3.setEditable(false);
        marco.add(imagen);
        imagen.setIcon(Imagen);
        imagen.setBounds(240, 380, 200, 200);
    }	

    int obtener () {

        Error.setText("");
        String aux;
        String a1[];
        aux=Cant.getText();
        x=leerdatos(aux);
        y = new int [x];
        aux=Num.getText();
        a1=aux.split(",");
        if (a1.length!=y.length) {
            Error.setForeground(new Color(124, 14, 14));
            Error.setText("Cantidad de numeros incorrecta");
            return 0;
        }
        for(int i=0;i<x;i++){
            aux=a1[i];
            y[i]=leerdatos(aux);
        }
        Arrays.sort(y);
        return x;
    }

    boolean verificacion(String x) {
        int j;
        try {
            j=Integer.parseInt(x);
            if(j<=0) {
                    return false;
            }
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    int leerdatos(String x) {
        int y=0;
        if (verificacion(x) == false) {
            Error.setForeground(new Color(124, 14, 14));
            Error.setText("Hay un caracter invalido");
        } else {
            y = Integer.parseInt(x);
        }
        return y;
    }

    int mcd(int a, int b) {
        if(b == 0) return a;
        mensaje1=mensaje1+(a+"="+b+"*"+a/b+"+"+a%b)+"\n";
        mensaje2=mensaje2+(b+"="+a%b+"*"+a/b+"-"+a)+"\n";
        return mcd(b, a%b);
    }

    long[] mcdext(int a, int b) {
        long[] r = new long [3];
        long x=0,y=0;
        if(b==0){
            r[0] = a; 
            r[1] = 1; 
            r[2] = 0;
        }else{
            long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
            long q = 0, re = 0; 
            while(b>0){
                q = (a/b);
                re = a - q*b;
                x = x2-q*x1;
                y = y2 - q*y1;
                a = b;
                b = (int) re;
                x2 = x1;
                x1 = x;
                y2 = y1;
                y1 = y;
            }
        r[0] = a;
        r[1] = x2;
        r[2] = y2;
        }
        return r;
    }

    int calcular(int j) {
        int k=y[j];
        long[] r = new long [3];
        for(int i=j; i>0; i--) {
            k=mcd(k,y[i-1]);
            mensaje1=mensaje1+"\n";
            mensaje2=mensaje2+"\n";
        }
        k=y[j];
        for(int i=j; i>0; i--) {
            r=mcdext(k,y[i-1]);
            mensaje3=mensaje3+(r[0]+"="+"("+r[1]+")"+"*"+k+"+"+"("+r[2]+")"+"*"+y[i-1]+"\n");
            mensaje3=mensaje3+"\n";
            k=(int)r[0];
        }
        Error.setForeground(Color.blue);
        Error.setText("MCD:"+ k);
        return 0;
    }

    void escribir() {
        proceso1.setText(mensaje1);
        proceso2.setText(mensaje2);
        proceso3.setText(mensaje3);
    }

    void limpiar() {
        mensaje1=mensaje2=mensaje3="";
    }
}