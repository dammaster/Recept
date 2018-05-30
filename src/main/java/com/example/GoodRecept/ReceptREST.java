package com.example.GoodRecept;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ReceptREST

{
	private ReceptServiceImp receptServiceImp;


	@Autowired
	public ReceptREST(ReceptServiceImp receptServiceImp) {

		this.receptServiceImp = receptServiceImp;

	}


/*

	   //**********************SHOW ALL RECEPTS*************************ok
	@RequestMapping(path = "/recept" ,method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Recept>> getRecepts() throws IOException {
		List<Recept> recepts = receptServiceImp.getRecepts();
        return new ResponseEntity<List<Recept>>(recepts, HttpStatus.OK );
       }


	  //**********************ADD NEW**************************ok
	   @RequestMapping(value = "/recept" , method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseStatus(HttpStatus.CREATED)
	    public void insertRecept(@RequestBody Recept recept) {
           receptServiceImp.saveRecept(recept);
	       }

*/
	 //**********************SHOW RECEPT BY ID**************************ok
	@RequestMapping(path = "/recept/{id}" ,method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Recept> findRecept(@PathVariable long id ){

		Recept recept = receptServiceImp.findRecept( id );
        if( recept == null )

			return new ResponseEntity<Recept>( HttpStatus.NOT_FOUND );
            return new ResponseEntity<Recept>(recept, HttpStatus.OK );
            }




	//**********************UPDATE BY ID**************************ok
	@RequestMapping(value = "/recept/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateRecept(@PathVariable long id, @RequestBody Recept recept) {
		receptServiceImp.updateRecept(recept);
	}


	//**********************DELETE RECEPT BY ID**************************ok
	@RequestMapping(value = "/recept/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRecept(@PathVariable long id) {
		receptServiceImp.deleteRecept(id);
	}



	///////////////////////////////////////////////////////////////////////////
	//	                                                                     //
	//                                Save data.txt                          //
	//                      *uncomment toString() in Recept.java             //
	//	                                                                     //
	///////////////////////////////////////////////////////////////////////////




	//**********************SHOW ALL RECEPTS FROM data.txx***********ok
	@RequestMapping(path = "/recept", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<String>> getRecepts() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("/Users/daniel/Downloads/GoodRecept/src/main/resources/data.txt"));
		String linea;
		List<String> arlist = new ArrayList<String>();
		while ((linea = reader.readLine()) != null) {
			arlist.add(linea);
		}
		return new ResponseEntity<List<String>>(arlist, HttpStatus.OK);

	}


	///**********************ADD NEW in data.txt****************ok
	@RequestMapping(value = "/recept/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertRecept(@RequestBody Recept recept) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			receptServiceImp.saveRecept(recept);
			File file = new File("/Users/daniel/Downloads/GoodRecept/src/main/resources/data.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(String.valueOf(recept));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//close FileWriter and BufferedWriter
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}



	}
