import edu.duke.*;
import java.io.File;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        startIndex = dnaStr.indexOf("ATG");
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex +1);
            }
        }
        return dnaStr.length();
    }
    
    public String findGene(String dna, int where){
        int atgCodon = dna.indexOf("ATG", where);
        
        if (atgCodon == -1) {
            return "NO ATG CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int minCodon = 0;
        if (taaCodon == -1 ||
            (tgaCodon != -1 && tgaCodon < taaCodon)) {
                minCodon = tgaCodon;
            }
            else {
                minCodon = taaCodon;
            }
        if (minCodon == -1 ||
           (tagCodon != -1 && tagCodon < minCodon)){
               minCodon = tagCodon;
            }
        if (minCodon == -1) {
                return "No ending codon found";
            }
            
        return dna.substring(atgCodon, minCodon+3);
    }
    
    public void testFindGene(){
        /*String dna= "aaaaaATGaaaaaaaaaTAGaaaa";
        String gene = findGene(dna);
        System.out.println("This is my gene: " + gene);
        if (!gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("tests finished");*/
        /*String dna= "AGDEGAASZZATAAAAA";
        System.out.println("The dna string is :" + dna);
        String gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "aaaaaaATGaaaaaaaaaAAAAaaa";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);*/

    }
    
    public int countGenes(String dna){
        /*int count = 0;
        
        int firstOccur = dna.indexOf(findGene(dna));
        String wholeGene = findGene(dna);
        if (firstOccur > -1) {
            count = count+1;
        System.out.println("count 1 =" + count + " firstOccur= " +firstOccur + " gene string is: " + wholeGene + " this is the lenght: " +wholeGene.length() );
        
        while (dna.indexOf(wholeGene, firstOccur) != -1 && firstOccur != -1) {
            count = count +1;
            firstOccur = dna.indexOf(wholeGene, firstOccur)+wholeGene.length();
            System.out.println(dna +"count 2 =" + count + " firstOccur= " +firstOccur + " this is the lenght: " +wholeGene.length() );
            System.out.println("gene: " +wholeGene);
        }
        count = count -1;
        }
        else {
            count=0;
        }**/
        return 0;
    }
    public void countGenes2(String dna){
        int startIndex = 0;
        while (true){
            String wholeGene = findGene(dna, startIndex);
            if (wholeGene.isEmpty()){
                break;
            }
            System.out.println("Gene found: " + wholeGene);
            startIndex = dna.indexOf(wholeGene,startIndex)+wholeGene.length();
        }
    }
    
    public void testLast(){
        String dna = "ATGATCTAATTTATGaaaaaaaaaTGAAGA";
        System.out.println("Testing printGenes here " + dna);
        countGenes2(dna);
    }

   
    public void testCountGenes(){
        String dna= "aaaATGTAAGATGCCCTAGT";
        System.out.println("I should find 2 and found these amount of genes:" + countGenes(dna));
        
        dna= "ATGTAGATGTAAATGTAA";
        System.out.println("I should find 3 and found these amount of genes:" + countGenes(dna));
    }
}
    
    
   
