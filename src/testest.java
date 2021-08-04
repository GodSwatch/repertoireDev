//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//
//public class testest {
//    public static void main(String args[]) throws IOException {
//        //PREMIER TEST : LISTER LES ADRESSES IPS DU RESEAU ACCESSIBLE A PARTIR DU SUBNET
////        int timeout = 1000;
////        String subnet = "192.168.254";
////        int nb = 0;
////        try {
////            System.out.println(InetAddress.getLocalHost());
////        }
////        catch (UnknownHostException e) {
////            e.printStackTrace();
////        }
////        for (int i = 1; i < 255; i++) {
////            System.out.println(" N° : " + i);
////            String host = subnet + "." + i;
////            try {
////                if (InetAddress.getByName(host).isReachable(timeout)) {
////                    System.out.println(host + " est accessible");
////                    nb++;
////                }
////            }
////            catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////        System.out.println("Nombre de machines accessible : " + nb);
//
//    //TROISIEME TEST
//    ;
////        InetAddress adrLocale = null;
////        try {
////            adrLocale = InetAddress.getLocalHost();
////        } catch (UnknownHostException unknownHostException) {
////            unknownHostException.printStackTrace();
////        }
////        //Mon adresse locale
////        System.out.println("Adresse locale = " + adrLocale.getHostAddress());
////        InetAddress adrServeur = null;
////        try {
////            adrServeur = InetAddress.getByName("java.sun.com");
////        } catch (UnknownHostException unknownHostException) {
////            unknownHostException.printStackTrace();
////        }
////        System.out.println("Adresse Sun = " + adrServeur.getHostAddress());
////        InetAddress[] adrServeurs = new InetAddress[0];
////        try {
////            adrServeurs = InetAddress.getAllByName("www.esatic.ci");
////        } catch (UnknownHostException unknownHostException) {
////            unknownHostException.printStackTrace();
////        }
////
////        System.out.println("Adresses Microsoft : ");
////        for (int i = 0; i < adrServeurs.length; i++) {
////           System.out.println("     " + adrServeurs[i].getHostAddress().toString());
////           String mots[] = String.valueOf(adrServeurs[i].getHostAddress()).split("\\.");
////           System.out.println(mots.length);
////           String mots2 = mots[0] + "." + mots[1] + "." + mots[2];
////           System.out.println(mots2);
////           adresse(mots2);
////        }
////        String ip = "10.20.20.17";   // false in my case
////    String ip1 = "10.20.20.100"; // true in my case
//
//
//    //DEUXIEME TEST : CONNAITRE L'ADRESSE IP D'UN SITE
////    try {
////
////        InetAddress ip = null;
////        try {
////            ip = InetAddress.getByName("www.google.com");
////        } catch (UnknownHostException unknownHostException) {
////            unknownHostException.printStackTrace();
////        }
////
////        System.out.println("Host Name: " + ip.getHostName());
////
////       System.out.println("IP Address: " + ip.getHostAddress());
////    }
////    catch (Exception e) {
////       System.out.println(e);
////    }
//
//        //TEST QUATRE
//
//                String Ipv4Adr = "192.168.1.134";
//                try {
//                    //COMMANDE POUR FAIRE UN PING SUR UNE ADRESSE IP
//                    Process p1 = Runtime.getRuntime().exec("cmd /c " + "ping " + Ipv4Adr);
//                    new RecuperationSorties(p1.getInputStream()).run();
//                    new RecuperationSorties(p1.getErrorStream()).run();
//                    new RecuperationSorties(p1.getErrorStream()).run();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//    }
//
// public static void adresse(String adresseSubnet) {
//    int timeout = 1000;
//    for (int i = 1; i < 255; i++) {
//       System.out.println(" N° : " + i);
//
//       String host = adresseSubnet + "." + i;
//       try {
//          if (InetAddress.getByName(host).isReachable(timeout)) {
//             System.out.println(host + " est accessible");
//          }
//       }
//       catch (IOException e) {
//          e.printStackTrace();
//       }
//    }
// }
//}
