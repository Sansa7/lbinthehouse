package lbinthehouse;

import java.util.Scanner;

public class TransactionManagerCopy {
  public void schedule() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String line = sc.nextLine().trim();
      if (line.equals("exit")) {
        break;
      }
      if (line.startsWith("beginRO")) {
        int start = line.indexOf("(");
        int end = line.indexOf(")");
        String trans = line.substring(start + 1, end).trim();
        String transNum = trans.substring(1).trim();
        if (!transNum.matches("\\d+")) {
          continue;       
        }
        int transInt = Integer.parseInt(transNum);
        System.out.println("begin transaction " + trans + " numbered " + transNum);
      } else if (line.startsWith("R")) {
        int start = line.indexOf("(");
        int comma = line.indexOf(",");
        int end = line.indexOf(")");
        String trans = line.substring(start + 1, comma).trim();
        System.out.println(trans);
        String repli = line.substring(comma + 1, end).trim();
        System.out.println(repli);
        String transNum = trans.substring(1).trim();
        System.out.println(transNum);
        String repliNum = repli.substring(1).trim();
        if (!transNum.matches("\\d+")) {
          continue;       
        }
        int transInt = Integer.parseInt(transNum);
        if (!repliNum.matches("\\d+")) {
          continue;
        }
        int repliInt = Integer.parseInt(repliNum);
        System.out.println("read " + repli + " or acquire lock according the type of " + trans + " trans numbered as " + transInt + " repli numbered as " + repliInt);               
      } else if (line.startsWith("fail")) { 
        int start = line.indexOf("(");
        int end = line.indexOf(")");
        String siteNum = line.substring(start + 1, end).trim();
        //String siteNum = line.substring(site.indexOf("_"), end - 1).trim();
        if (!siteNum.matches("\\d+")) {
          continue;
        }
        int siteInt = Integer.parseInt(siteNum);
        System.out.println("mark site " + siteNum + " as down numbered as " + siteInt);
      } else if (line.startsWith("recover")) {
        int start = line.indexOf("(");
        int end = line.indexOf(")");
        String siteNum = line.substring(start + 1, end).trim();
        System.out.println(siteNum);
        if (!siteNum.matches("\\d+")) {
          continue;
        }
        int siteInt = Integer.parseInt(siteNum);
        System.out.println("mark site " + siteNum + " as up numbered as " + siteInt);
      }      
    }    
  }

}
