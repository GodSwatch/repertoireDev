import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //PREMIER TEST : LISTER LES ADRESSES IPS DU RESEAU ACCESSIBLE A PARTIR DU SUBNET
//        int timeout=1000;
//        String subnet = "192.168.254";
//        int nb=0;
//        try {
//            System.out.println(InetAddress.getLocalHost());
//        }
//        catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        for (int i=1;i<255;i++)
//        {
//            System.out.println(" N° : " + i);
//
//            String host=subnet + "." + i;
//            try {
//                if (InetAddress.getByName(host).isReachable(timeout))
//                {
//                    System.out.println(host + " est accessible");
//                    nb++;
//                }
//
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Nombre de machines accessible : "+ nb);
        //DEUXIEME TEST : CONNAITRE L'ADRESSE IP D'UN SITE
//    try {
//
//       InetAddress ip = InetAddress.getByName("www.google.com");
//
//       System.out.println("Host Name: " + ip.getHostName());
//
//       System.out.println("IP Address: " + ip.getHostAddress());
//    }
//    catch (Exception e) {
//       System.out.println(e);
//    }

//        //TROISIEME TEST reprise
//
        String mots2;
        String addr;
        try {
            InetAddress adrLocale = InetAddress.getLocalHost();
            //Mon adresse locale
            System.out.println("Adresse locale = " + adrLocale.getHostAddress());
            InetAddress adrServeur = InetAddress.getByName("java.sun.com");
            System.out.println("Adresse Sun = " + adrServeur.getHostAddress());
            InetAddress[] adrServeurs = InetAddress.getAllByName("www.esatic.ci");
            System.out.println("Adresses Esatic : ");
            for (int i = 0; i < adrServeurs.length; i++) {
                System.out.println("     " + adrServeurs[i].getHostAddress());
                String mots[] = new String[3];
                addr = adrServeurs[i].getHostAddress();
                System.out.println(addr);
                mots = addr.split("\\.");
                mots2 = mots[0] + "." + mots[1] + "." + mots[2];
                adresse(mots2);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//    }
//        //TEST QUATRE
//    try {
//        // Énumération de toutes les cartes réseau.
//        Enumeration<NetworkInterface> interfaces = null;
//        try {
//            interfaces = NetworkInterface.getNetworkInterfaces();
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//        while (((Enumeration<?>) interfaces).hasMoreElements()) {
//            NetworkInterface interfaceN = (NetworkInterface) interfaces.nextElement();
//            System.out.println("----> " + interfaceN.getDisplayName());
//            Enumeration<InetAddress> iEnum = interfaceN.getInetAddresses();
//            while (iEnum.hasMoreElements()) {
//                InetAddress inetAddress = iEnum.nextElement();
//                System.out.println(inetAddress.getHostAddress());
//            }
//        }
//    } catch (Exception ex) {
//        System.out.println("pas de carte réseau.");
//        ex.printStackTrace();
//    }

//    //TEST CINQ
//        try {
//            // Énumération de toutes les cartes réseau.
//            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//            while (interfaces.hasMoreElements()) {
//                NetworkInterface interfaceN = (NetworkInterface) interfaces.nextElement();
//                System.out.println("----> " + interfaceN.getDisplayName());
//                List<InterfaceAddress> iaList= interfaceN.getInterfaceAddresses();
//                for (InterfaceAddress interfaceAddress : iaList) {
//                    System.out.println(interfaceAddress.getAddress().getHostAddress());
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println("pas de carte réseau.");
//            ex.printStackTrace();
//        }

        //OK TEST SIX (un defaut apercu) LISTER LES MACHINES DU RESEAU QUI SONT ACCESSIBLE https://openclassrooms.com/forum/sujet/ping-correct-et-efficace-en-java-31093
//        InetAddress ia;
//        String adresse = "164.160.41.";
//        String tmp = "";
//        for (int i = 0; i < 254; i++) {
//            tmp = adresse + i;
//            ia = InetAddress.getByName(tmp);
//            System.out.println(tmp + " est accessible?: " + (ia.isReachable(3000) ? "Oui" : "Non") + " - " + ia.getCanonicalHostName() + "/" + ia.getHostName());
//
//            //Process proc = new ProcessBuilder("ping", tmp).start();
//            Process proc = Runtime.getRuntime().exec("ping " + tmp);
//            if (proc.waitFor() == 0)
//                System.out.println(tmp + " est vraiment accessible");
//        }

//        //TEST SEPT LISTER LES MACHINES DU RESEAU QUI SONT ACCESSIBLE
//
//        InetAddress  localhost = InetAddress .getLocalHost();
//
//        byte[] ip = localhost.getAddress();
//
//        for (int i = 1; i <= 254; i++)
//        {
//            ip[3] = (byte)i;
//            InetAddress  address = InetAddress .getByAddress(ip);
//            if (address.isReachable(1000))
//            {
//                System .out.println(address + " machine is turned on and can be pinged");
//            }
//            else if (!address.getHostAddress().equals(address.getHostName()))
//            {
//                System .out.println(address + " machine is known in a DNS lookup");
//            }
//            else
//            {
//                System .out.println(address + " the host address and host name are equal, meaning the host name could not be resolved");
//            }
//        }

//        //TEST HUIT OBTENIR LE NOM DE LA MACHINE et son adresse

//        InetAddress ip;
//        String hostname;
//        try {
//            ip = InetAddress.getByName("www.gouv.ci");
//            hostname = ip.getHostName();
//            System.out.println("Your current IP address : " + ip);
//            System.out.println("Your current Hostname : " + hostname);
//
//        } catch (UnknownHostException e) {
//
//            e.printStackTrace();
//        }

        //FONCTION RECONNAITRE LA CLASSE D'UNE ADRESSE IP


    }


        //FONCITON ACCESIBILITE DES IPS
    public static void adresse(String adresseSubnet) {
        int timeout = 1000;
        for (int i = 1; i < 255; i++) {
            System.out.println(" N° : " + i);
            String host = adresseSubnet + "." + i;
            try {
                if (InetAddress.getByName(host).isReachable(timeout)) {
                    System.out.println(host + " est accessible");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Fonction pour lister toutes les machines en fonction du type ou de la classe d'adresse IP
     *
     * @param nomDomaine
     * @throws UnknownHostException
     */
    public void listerAdresseReseau(String nomDomaine) throws IOException, InterruptedException {

        InetAddress adrServeur = InetAddress.getByName(nomDomaine);
        String adresseServeur = adrServeur.getHostAddress();
        String classeEtOctet1 = retourneClasseIp(adresseServeur);
        String tabClasseEtOctet1[];
        tabClasseEtOctet1 = classeEtOctet1.split("sep");
        switch (tabClasseEtOctet1[0]) {
            case ("A"):
                listerAdresseReseauClasseA(tabClasseEtOctet1[1]);
                break;
            case ("B"):
                listerAdresseReseauClasseB(tabClasseEtOctet1[1]);
            case ("C"):
                listerAdresseReseauClasseC(tabClasseEtOctet1[1]);
            default:
                System.out.println("Il ne s'agit pas d'une adresse IP de classe A, B, ou C ");
        }
    }

    /**
     * Fonction pour retourner une classe d'adresse IP
     *
     * @param adrServeur
     */
    public String retourneClasseIp(String adrServeur) {
        Integer octet1;
        String result;
        String tabOctets[];
        tabOctets = adrServeur.split("\\.");
        octet1 = Integer.parseInt(tabOctets[0]);
        if (octet1 >= 0 && octet1 < 128) {
            result = "A" + "sep" + octet1 + ".";
        } else if (octet1 >= 128 && octet1 < 192) {
            result = "B" + "sep" + octet1 + "." + tabOctets[1] + ".";
        } else if (octet1 >= 192 && octet1 < 223) {
            result = "C" + "sep" + octet1 + "." + tabOctets[1] + "." + tabOctets[2] + ".";
        } else {
            result = "Other";
        }
        return result;
    }

    /**
     * Fonction pour lister toutes les machines d'adresse IP de classe A
     *
     * @param subnetA
     * @throws IOException
     * @throws InterruptedException
     */
    public void listerAdresseReseauClasseA(String subnetA) throws IOException, InterruptedException {
        InetAddress ia;
        String tmp = "";
        for (int i = 1; i < 254; i++) {
            tmp = subnetA + i;
            for (int j = 1; j < 254; j++) {
                tmp = tmp + j;
                for (int k = 1; k < 254; k++) {
                    tmp = tmp + k;
                    ia = InetAddress.getByName(tmp);
                    System.out.println(tmp + " est accessible?: " + (ia.isReachable(3000) ? "Oui" : "Non") + " - " + ia.getCanonicalHostName() + "/" + ia.getHostName());
                    Process proc = Runtime.getRuntime().exec("ping " + tmp);
                    if (proc.waitFor() == 0)
                        System.out.println(tmp + " est vraiment accessible");
                }
            }
        }
    }

    /**
     * Fonction pour lister toutes les machines d'adresse IP de classe B
     *
     * @param subnetB
     * @throws IOException
     * @throws InterruptedException
     */
    public void listerAdresseReseauClasseB(String subnetB) throws IOException, InterruptedException {
        InetAddress ia;
        String tmp = "";
        for (int i = 1; i < 254; i++) {
            tmp = subnetB + i;
            for (int j = 1; j < 254; j++) {
                tmp = tmp + j;
                ia = InetAddress.getByName(tmp);
                System.out.println(tmp + " est accessible?: " + (ia.isReachable(3000) ? "Oui" : "Non") + " - " + ia.getCanonicalHostName() + "/" + ia.getHostName());
                Process proc = Runtime.getRuntime().exec("ping " + tmp);
                if (proc.waitFor() == 0)
                    System.out.println(tmp + " est vraiment accessible");
            }
        }
    }


    /**
     * Fonction pour lister toutes les machines d'adresse IP de classe C
     *
     * @param subnetC
     * @throws IOException
     * @throws InterruptedException
     */
    public void listerAdresseReseauClasseC(String subnetC) throws IOException, InterruptedException {
        InetAddress ia;
        String tmp = "";
        for (int i = 1; i < 254; i++) {
            tmp = subnetC + i;
                ia = InetAddress.getByName(tmp);
                System.out.println(tmp + " est accessible?: " + (ia.isReachable(3000) ? "Oui" : "Non") + " - " + ia.getCanonicalHostName() + "/" + ia.getHostName());
                Process proc = Runtime.getRuntime().exec("ping " + tmp);
                if (proc.waitFor() == 0)
                    System.out.println(tmp + " est vraiment accessible");
        }
    }
}
