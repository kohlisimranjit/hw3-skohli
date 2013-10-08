
package com.cmu.edu.deiis.casConsumer;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.text.AnnotationIndex;
//import org.apache.uima.collection.CasConsumer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;
//import org.cleartk.token.type.Sentence;

import edu.cmu.deiis.subTypes.Document;

public class EvaluatedSetCasConsumer extends CasConsumer_ImplBase{

	@Override
	public void processCas(CAS cas) throws ResourceProcessException {
		System.out.println("Enterd "+this.getClass().getName());
		
		System.out.println(cas.toString());
		
		Type type=cas.getAnnotationType();
		
		cas.getAnnotationIndex(type);
		//Type Sentence=new Sentence(cas);
		//System.out.println("--------------aaaaaaaaaaaaaaa-----------------------");
		AnnotationIndex<AnnotationFS> afs=	cas.getAnnotationIndex(type);
		
		Iterator<AnnotationFS> sentenceIndexIterator =afs.iterator();
		
		while(sentenceIndexIterator.hasNext())
		{
			Object obj=sentenceIndexIterator.next();
			
		//	System.out.println("OBJCLASS->"+obj.getClass()+"\t String"+obj.toString());
		}
		//cas.getAnnotationIndex(Sentence);
		// TODO Auto-generated method stub
	//	JCas jCas=(JCas)cas;
	//	System.out.println("Typecat SUCESS!");
		/*
		
		Sentence document = null;
		FSIndex<Annotation> sentenceIndex = jCas.getAnnotationIndex(Sentence.type);		//FSIndex<Annotation> docIndex = jCas.getAnnotationIndex(Sentence.type);
		// FSIndex<Annotation> docIndex =
		// jCas.getAnnotationIndex(Document.type);

		Iterator<Annotation> sentenceIndexIterator = sentenceIndex.iterator();

		while((document = (Sentence) sentenceIndexIterator.next())!=null)
		{
			
			System.out.println(document);
		}*/
		
		
		
	}

}
