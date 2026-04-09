/**
* Engenharia de Software Moderna - Padrões de Projeto (Cap. 6)
* Prof. Marco Tulio Valente
* 
* Exemplo do padrão de projeto Fábrica
*
*/

/**
* Interface e classe dos objetos que serão fabricados.
*/

interface Notification {}

class Email implements Notification {}
class SMS implements Notification {}
class Push implements Notification {}


/**
* A classe ChannelFactory implementa um método fábrica estático.
* Isto é, um método que centraliza a criação de objetos que
* implementam a interface Channel
*
* Se amanhã quisermos que o sistema use UDPChannel, basta
* mudar a implementação de create()
*/

class Notify {
  
  public static Notification create(String tipo) { // método fábrica estático
    switch (tipo.toLowerCase){
      case "email": 
        System.out.println("Canal de e-mail escolhido");
        return new Email();
        break;
      case "SMS":
        System.out.println("Canal de SMS escolhido");
        return new SMS();
        break;
      case "push":
        System.out.println("Canal de push notification escolhido");
        return new Push();
        break;
      default:
        System.out.println("Erro");
  }

}

public class Main { 

  void f() {
    Notification c = Notify.create("email");  
  }

  void g() {
    Notification c = Notify.create("SMS");
  }
  
  void h() {
    Channel c = Notify.create("push");
  }
  
  public static void main(String [] args) {
     Main m = new Main();
     m.f();
     m.g();
     m.h(); 
  }

}
