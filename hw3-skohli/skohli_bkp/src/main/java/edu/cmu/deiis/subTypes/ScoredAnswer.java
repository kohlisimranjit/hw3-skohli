

/* First created by JCasGen Thu Sep 19 18:23:47 EDT 2013 */
package edu.cmu.deiis.subTypes;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.AnswerScore;


/** 
 * Updated by JCasGen Thu Sep 19 19:23:57 EDT 2013
 * XML source: /home/richie/git/hw2-skohli/hw2-skohli/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class ScoredAnswer extends AnswerScore {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ScoredAnswer.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ScoredAnswer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ScoredAnswer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ScoredAnswer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ScoredAnswer(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: answerText

  /** getter for answerText - gets 
   * @generated */
  public String getAnswerText() {
    if (ScoredAnswer_Type.featOkTst && ((ScoredAnswer_Type)jcasType).casFeat_answerText == null)
      jcasType.jcas.throwFeatMissing("answerText", "edu.cmu.deiis.subTypes.ScoredAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ScoredAnswer_Type)jcasType).casFeatCode_answerText);}
    
  /** setter for answerText - sets  
   * @generated */
  public void setAnswerText(String v) {
    if (ScoredAnswer_Type.featOkTst && ((ScoredAnswer_Type)jcasType).casFeat_answerText == null)
      jcasType.jcas.throwFeatMissing("answerText", "edu.cmu.deiis.subTypes.ScoredAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((ScoredAnswer_Type)jcasType).casFeatCode_answerText, v);}    
  }

    