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
}

class Logger{
  
  private Logger() {}

  private static Logger instance;

  public static Logger getInstance() {
      if (instance == null) // 1a vez que chama-se getInstance
        instance = new Logger();
      return instance;
  }

  public void mensagem(String msg) {
    System.out.println(msg);
  }
  

public class Main { 

  void f() {
    Notification c = Notify.create("email");
    Logger log = Logger.getInstance();
    log.mensagem("Executando f" + log);
  }

  void g() {
    Notification c = Notify.create("SMS");
    Logger log = Logger.getInstance();
    log.mensagem("Executando g" + log);
  }
  
  void h() {
    Channel c = Notify.create("push");
    Logger log = Logger.getInstance();
    log.mensagem("Executando h" + log);
  }
  
  public static void main(String [] args) {
     Main m = new Main();
     m.f();
     m.g();
     m.h(); 
  }

}
