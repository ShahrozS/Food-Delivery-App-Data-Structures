import java.util.HashMap;
import java.util.Map;

public class hash {



    class hashnode{
        char key,value;

    }


String encrypt (String password ){
    Map<String,String> p =  new HashMap<>();

    p.put("a","qw");
    p.put("b","we");
    p.put("c","er");
    p.put("d","rt");
    p.put("e","ty");
    p.put("f","yu");
    p.put("g","ui");
    p.put("h","io");
    p.put("i","pa");
    p.put("j","as");
    p.put("k","sd");
    p.put("l","df");
    p.put("m","fg");
    p.put("n","gh");
    p.put("o","hj");
    p.put("p","jk");
    p.put("q","kl");
    p.put("r","lz");
    p.put("s","xc");
    p.put("t","cv");
    p.put("u","vb");
    p.put("v","bn");
    p.put("w","nm");
    p.put("x","qr");
    p.put("y","et");
    p.put("z","ad");

    p.put("A","qw");
    p.put("B","we");
    p.put("C","er");
    p.put("D","rt");
    p.put("E","ty");
    p.put("F","yu");
    p.put("G","ui");
    p.put("H","io");
    p.put("I","pa");
    p.put("J","as");
    p.put("K","sd");
    p.put("L","df");
    p.put("M","fg");
    p.put("N","gh");
    p.put("O","hj");
    p.put("P","jk");
    p.put("Q","kl");
    p.put("R","lz");
    p.put("S","xc");
    p.put("T","cv");
    p.put("U","vb");
    p.put("V","bn");
    p.put("W","nm");
    p.put("X","qr");
    p.put("Y","et");
    p.put("Z","ad");

    p.put("1","tb");
    p.put("2","uv");
    p.put("3","uc");
    p.put("4","wm");
    p.put("5","zp");
    p.put("6","hp");
    p.put("7","bf");
    p.put("8","ag");
    p.put("9","zv");
    p.put("0","af");


    StringBuffer sb = new StringBuffer(password);
    String enc  = "" ;
for(int i = password.length()-1 ; i >=0;i--){

    enc = enc+p.get(password.substring(password.length()-1));

  password=  removeLastChar(password);
}

    return enc;
    }



    private String removeLastChar(String s)
    {
        return s.substring(0, s.length() - 1);
    }
    private String removeLastChar2(String s)
    {
        return s.substring(0, s.length() - 2);
    }
String decrypter(String password){
    Map<String,String> p =  new HashMap<>();

    p.put("qw","a");
    p.put("we","b");
    p.put("er","c");
    p.put("rt","d");
    p.put("ty","e");
    p.put("yu","f");
    p.put("ui","g");
    p.put("io","h");
    p.put("pa","i");
    p.put("as","j");
    p.put("sd","k");
    p.put("df","l");
    p.put("fg","m");
    p.put("gh","n");
    p.put("hj","o");
    p.put("jk","p");
    p.put("kl","q");
    p.put("lz","r");
    p.put("xc","s");
    p.put("cv","t");
    p.put("vb","u");
    p.put("bn","v");
    p.put("nm","w");
    p.put("qr","x");
    p.put("et","y");
    p.put("ad","z");

    p.put("qw","A");
    p.put("we","B");
    p.put("er","C");
    p.put("rt","D");
    p.put("ty","E");
    p.put("yu","F");
    p.put("ui","G");
    p.put("io","H");
    p.put("pa","I");
    p.put("as","J");
    p.put("sd","K");
    p.put("df","L");
    p.put("fg","M");
    p.put("gh","N");
    p.put("hj","O");
    p.put("jk","P");
    p.put("kl","Q");
    p.put("lz","R");
    p.put("xc","S");
    p.put("cv","T");
    p.put("vb","U");
    p.put("bn","V");
    p.put("nm","W");
    p.put("qr","X");
    p.put("et","Y");
    p.put("ad","Z");

    p.put("tb","1");
    p.put("uv","2");
    p.put("uc","3");
    p.put("wm","4");
    p.put("zp","5");
    p.put("hp","6");
    p.put("bf","7");
    p.put("ag","8");
    p.put("zv","9");
    p.put("af","0");
    String enc  = "" ;
    for(int i = password.length()-2 ; i >=0;i=i-2){
        System.out.println("1: " +password);
        enc = enc+p.get(password.substring(i));

        password=  removeLastChar2(password);
    }
    return enc;
    }

}

