package com.mansiti.wuzzufjobs.resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.json.JSONObject;
import smile.data.DataFrame;
import smile.io.Read;
import smile.plot.swing.BoxPlot;
import smile.plot.swing.Canvas;


/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {
    
    private String path = "C:\\Users\\Yasser\\Documents\\NetBeansProjects\\wuzzufJobs\\src\\main\\resources\\data\\Wuzzuf_Jobs_1.csv";
    
   

    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("/summary")
    @Produces(MediaType.APPLICATION_JSON)
    public String readCSV2(){
//        JavaEE8Resource je = new JavaEE8Resource();
        DataFrame df = readCSV (path);
//        DataFrame dfCompany = df.select("Company","Title");
//        DataFrame dfCountry = df.select("Country","Title");
//        DataFrame dfSkill = df.select("Skills","Title");
//        return df.slice(0,50).toString(); // get first 50 rows
        return df.structure().toString()+ "\n \n \n"+ df.slice(0,50).toString(); // Structure
    }
    
    
    
    @GET
    @Path("/getCompany")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompaniesCount(){
        DataFrame df = readCSV (path);
        DataFrame dfCompany = df.select("Company","Title");
        
        Map<String, Long> lmap = dfCompany.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Company"), Collectors.counting()));
        
//        Map<String, Long> map = lmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
//        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        Map<String, Long> map = lmap.entrySet().
            stream().
            sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
//        String[] breaks = (String[]) map.keySet().toArray(new String[map.size()]);
//        
//        int[] valuesInt = ((Collection<Long>) map.values ())
//                .stream ().mapToInt (i -> i.intValue ())
//                .toArray ();
//        
//        StringBuilder st = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            st.append(breaks[i]+" , "+ valuesInt[i]+"\n");
//        }
        
        JSONObject json = new JSONObject(map);
        
        return json.toString();
    }
    
    
    @GET
    @Path("/getTitle")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTitlesCount(){
        DataFrame df = readCSV (path);
        DataFrame dfCompany = df.select("Company","Title");
        
        Map<String, Long> lmap = dfCompany.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Title"), Collectors.counting()));
        
//        Map<String, Long> map = lmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
//        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        Map<String, Long> map = lmap.entrySet().
            stream().
            sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
//        String[] breaks1 = (String[]) map.keySet().toArray(new String[map.size()]);
//        
//        int[] valuesInt1 = ((Collection<Long>) map.values ())
//                .stream ().mapToInt (i -> i.intValue ())
//                .toArray ();
//        st.append("\n");
//        st.append("\n");
//        st.append("\n");
//        for (int i = 0; i < 10; i++) {
//            st.append(breaks1[i]+" , "+ valuesInt1[i]+"\n");
//        }
//        
        JSONObject json = new JSONObject(map);
        
        return json.toString();
    }
    
    @GET
    @Path("/getCountry")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountriesCount(){
        DataFrame df = readCSV (path);
        DataFrame dfCountry = df.select("Country","Title");
        
        Map<String, Long> lmap = dfCountry.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Country"), Collectors.counting()));
        
//        Map<String, Long> map = lmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
//        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        Map<String, Long> map = lmap.entrySet().
            stream().
            sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
//        String[] breaks2 = (String[]) map.keySet().toArray(new String[map.size()]);
//        
//        int[] valuesInt2 = ((Collection<Long>) map.values ())
//                .stream ().mapToInt (i -> i.intValue ())
//                .toArray ();
//        for (int i = 0; i < 10; i++) {
//            st.append(breaks2[i]+" , "+ valuesInt2[i]+"\n");
//        }
        JSONObject json = new JSONObject(map);
        
        return json.toString();
    }
    
    @GET
    @Path("/getskill")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSkillsCount(){
        DataFrame df = readCSV (path);
        DataFrame dfSkill = df.select("Skills","Title");
        
        Map<String, Long> lmap = dfSkill.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Skills"), Collectors.counting()));
        
//        Map<String, Long> map = lmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
//        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        Map<String, Long> map = lmap.entrySet().
            stream().
            sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        String[] breaks3 = (String[]) map.keySet().toArray(new String[map.size()]);
        
        int[] valuesInt3 = ((Collection<Long>) map.values ())
                .stream ().mapToInt (i -> i.intValue ())
                .toArray ();
        
        String[] spl;
        Map<String, Long> skills = new HashMap<String, Long>();
        
        for (int i = 0; i < breaks3.length; i++) {
//            st.append(breaks3[i]+" , "+ valuesInt3[i]+"\n");
            spl = breaks3[i].split(",");
            for(int k=0; k < spl.length; k++){
                if(skills.containsKey(spl[k])){
//                    System.out.println(skills.get(spl[k])+" : "+spl[k]);
                    long x = skills.get(spl[k]) + valuesInt3[i];
                    skills.replace(spl[k], x);
                }else{
                    long x =valuesInt3[i];
                    skills.put(spl[k], x);
                }
                
            }
            
        }
        
//        Map<String, Long> map = lmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
//        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        map = skills.entrySet().
            stream().
            sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
//        String[] breaks4 = (String[]) map.keySet().toArray(new String[map.size()]);
//        
//        int[] valuesInt4 = ((Collection<Long>) map.values ())
//                .stream ().mapToInt (i -> i.intValue ())
//                .toArray ();
//        for (int i = 0; i < 50; i++) {
//            st.append(breaks4[i]+" , "+ valuesInt4[i]+"\n");
//        }
        
        JSONObject json = new JSONObject(map);
        
        return json.toString();
    }
    
    public DataFrame readCSV(String path) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
        } catch (IOException e) {
            e.printStackTrace ();
            System.out.println (df.summary ()+"cccccccccccccc");
        } catch (URISyntaxException e) {
            e.printStackTrace ();
            System.out.println (df.summary ()+"dddddddddddddd");
        }
//        System.out.println ();
        return df;
    }
    
    
    
}
