import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainToutTypeClasseIP {
    /**
     * Fonction principale pour tester nos fonctions
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //TEST 1 METHODE AVEC FOR****

        String nomDomaine1 = "www.google.com";
        String nomDomaine2 = "www.esatic.ci";
        String nomDomaine3 = "www.culture-informatique.net";
        String nomDomaine4 = "www.javatpoint.com";
        listerAdresseReseau(nomDomaine2);

        //TEST 2 METHODE AVEC getByAllName() ****
//        String mots2;
//        String addr;
//        try {
//            InetAddress adrLocale = InetAddress.getLocalHost();
//            //Mon adresse locale
//            System.out.println("Adresse locale = " + adrLocale.getHostAddress());
//            InetAddress adrServeur = InetAddress.getByName("java.sun.com");
//            InetAddress adrServeurOk = InetAddress.getByName("f1153.prosol.pri");
//            System.out.println("Adresse Sun = " + adrServeur.getHostAddress());
//            InetAddress[] adrServeurs = InetAddress.getAllByName("www.esatic.ci");
//            InetAddress[] adrServeurs1 = InetAddress.getAllByName("www.nsa.gov");
//            InetAddress[] adrServeurs2 = InetAddress.getAllByName("www.itanimulli.com");
//            System.out.println("Essaie"+Arrays.toString(adrServeurs1)+" Et "+Arrays.toString(adrServeurs2)+" Et "+adrServeurOk.toString());
//            System.out.println("Adresses Esatic : ");
////            for (int i = 0; i < adrServeurs.length; i++) {
////                System.out.println("     " + adrServeurs[i].getHostAddress());
////                String mots[] = new String[3];
////                addr = adrServeurs[i].getHostAddress();
////                System.out.println(addr);
////                mots = addr.split("\\.");
////                mots2 = mots[0] + "." + mots[1] + "." + mots[2];
////                adresse(mots2);
////            }
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Fonction pour lister toutes les machines en fonction nom de domaine
     *
     * @param nomDomaine
     * @throws UnknownHostException
     */
    public static void listerAdresseReseau(String nomDomaine) throws IOException, InterruptedException {

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
                break;
            case ("C"):
                listerAdresseReseauClasseC(tabClasseEtOctet1[1]);
                break;
            default:
                System.out.println("Il ne s'agit pas d'une adresse IP de classe A, B, ou C ");
                break;
        }
    }

    /**
     * Fonction pour retourner une classe d'adresse IP
     *
     * @param adrServeur
     */
    public static String retourneClasseIp(String adrServeur) {
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
    public static void listerAdresseReseauClasseA(String subnetA) throws IOException, InterruptedException {
        System.out.println("************* Ce nom de domaine correspond à une adresse IP de classe A *************");
        InetAddress ia;
        String tmp0 = "";
        String tmp1 = "";
        String tmp2 = "";
        String tmp = "";
        for (int i = 1; i < 254; i++) {
            tmp0 = subnetA + i;
            tmp1 = tmp0;
            for (int j = 1; j < 254; j++) {
                tmp = tmp1;
                tmp = tmp + "." + j;
                tmp2 = tmp;
                for (int k = 1; k < 254; k++) {
                    tmp = tmp2;
                    tmp = tmp + "." + k;
                    listerAdresseContenu(tmp);
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
    public static void listerAdresseReseauClasseB(String subnetB) throws IOException, InterruptedException {
        System.out.println("************* Ce nom de domaine correspond à une adresse IP de classe B *************");
        InetAddress ia;
        String tmp = "";
        String tmp0 = "";
        for (int i = 1; i < 3; i++) {
            tmp0 = subnetB + i;
            for (int j = 1; j < 3; j++) {
                tmp = tmp0;
                tmp = tmp + "." + j;
                listerAdresseContenu(tmp);
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
    public static void listerAdresseReseauClasseC(String subnetC) throws IOException, InterruptedException {
        System.out.println("************* Ce nom de domaine correspond à une adresse IP de classe C *************");
        String tmp = "";
        for (int i = 1; i < 254; i++) {
            tmp = subnetC + i;
            listerAdresseContenu(tmp);
        }
    }

    /**
     * Fontion contenu pour lister a partir de l'adresse IP
     *
     * @param adresseIp
     * @throws IOException
     * @throws InterruptedException
     */
    public static void listerAdresseContenu(String adresseIp) throws IOException, InterruptedException {
        InetAddress ia;
        ia = InetAddress.getByName(adresseIp);
        System.out.println(adresseIp + " est accessible?: " + (ia.isReachable(3000) ? "Oui" : "Non") + " - " + ia.getCanonicalHostName() + "/" + ia.getHostName());
        Process proc = Runtime.getRuntime().exec("ping " + adresseIp);
        if (proc.waitFor() == 0)
            System.out.println(adresseIp + " est vraiment accessible");
    }

    /**
     * Fonction pour lister à partir du subnet (dans le cas du test2)
     *
     * @param adresseSubnet
     */
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


}
