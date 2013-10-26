
package com.cmu.edu.deiis.casConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.text.AnnotationIndex;
//import org.apache.uima.collection.CasConsumer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;
//import org.cleartk.token.type.Sentence;



import edu.cmu.deiis.subTypes.AnnotatedAnswer;
import edu.cmu.deiis.subTypes.Document;
import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.utils.AnswerComparator;

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
			
			System.out.println("OBJCLASS->"+obj.getClass()+"\t String"+obj.toString());
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
		
	/*	System.out.println("entered"+this.getClass().getName());
		Document document = null;
		//JCas jCas=cas;
		FSIndex<Annotation> docIndex = ((JCas)cas).getAnnotationIndex(Document.type);
		// FSIndex<Annotation> docIndex =
		// jCas.getAnnotationIndex(Document.type);

		Iterator<Annotation> docIterator = docIndex.iterator();

		document = (Document) docIterator.next();
		
		List<AnnotatedAnswer> AnnotatedAnswerList=new ArrayList<AnnotatedAnswer>();
		FSArray documentAnswerArray = document.getAnswers();
		
		int correct=0;
		int N=0;
		for(int i=0;i<documentAnswerArray.size();i++)
		{
			AnnotatedAnswerList.add((AnnotatedAnswer)documentAnswerArray.get(i));
		}
		
		
		Object		AnnotatedAnswerPbjectrray[]=AnnotatedAnswerList.toArray();
		
		AnnotatedAnswer AnnotatedAnswerrray[]=new AnnotatedAnswer[AnnotatedAnswerPbjectrray.length];
		for(int i=0;i<AnnotatedAnswerrray.length;i++)
		{AnnotatedAnswerrray[i]=(AnnotatedAnswer)AnnotatedAnswerPbjectrray[i];
			
			
		}
		
		Arrays.sort(AnnotatedAnswerrray,AnswerComparator.getInstance());
		
		for(int i=0;i<documentAnswerArray.size();i++){		
			documentAnswerArray.set(i, AnnotatedAnswerrray[i]);
			Answer answer=AnnotatedAnswerrray[i].getAnswer();
			
			if(AnnotatedAnswerrray[i].getScore()==1)
			{N++;
			
			if(answer.getIsCorrect())
			correct++;
			}
	System.out.println(AnnotatedAnswerrray[i].getText()+" "+AnnotatedAnswerrray[i].getConfidence()+" "+AnnotatedAnswerrray[i].getScore()+" "+answer.getIsCorrect());
		
		}
		//AnnotatedAnswer ArrayAnnotated []=new AnnotatedAnswer[10];  	
		
		System.out.println("Precision->"+(double)correct/N);*/
		
		
	}

}
