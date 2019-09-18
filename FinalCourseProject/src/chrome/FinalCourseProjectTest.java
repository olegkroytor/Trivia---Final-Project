package chrome;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING.NAME_ASCENDING)
public class FinalCourseProjectTest {
	
	@Before
    public void createBrowser(){
		FinalCourseProject.createBrowser();
    }
	
	@AfterAll
    public void closeBrowser(){
		FinalCourseProject.closeBrowser();
    }
	
	@Test
	public void test_0_trivia_open() {          
		assertEquals(true, FinalCourseProject.openTriviaSite());
	}
	
	/*
	 *    QUESTION 1
	 */
	
	@Test
	public void test_1_question_1_input () {          // true
		String value = "What is the first day of the week?";
		
		FinalCourseProject.openTriviaSite();
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_2_question_1_input_with_special_symbol () {   
		String value = "What's the day today?";
		
		FinalCourseProject.openTriviaSite();
		
		boolean bool = FinalCourseProject.question_fill_(value);
		assertEquals(true, bool);
		if (bool) {	
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@Test
	public void test_3_question_1_input_number_and_words_together () {   
		String value = "12345 abcde 67890 fghjk ?";
		
		FinalCourseProject.openTriviaSite();
		boolean bool = FinalCourseProject.question_fill_(value);
		assertEquals(true, bool);
		if (bool) {	
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@Test
	public void test_4_question_1_input_special_symbols_only () {   
		String value = "! @ # $ % ^ & :) ?";
		
		FinalCourseProject.openTriviaSite();
		boolean bool = FinalCourseProject.question_fill_(value);
		assertEquals(true, bool);
		if (bool) {	
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"",
			"W",
			"What is the day today and the month and the year?",
			"What is the day today and the month and the year ?"})
	void test_5_question_1_input_0_1_49_50_length_values (String value){
		System.out.println("value " + value);
		System.out.println("value lenght " + value.length());
		
		FinalCourseProject.openTriviaSite();
		boolean bool = FinalCourseProject.question_fill_(value);
		assertEquals(true, bool);
		if (bool) {	
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"What?",
			"Whats the?",
			"Whats the day today?",
			"Whats the day today and the month today?"})
	void test_6_question_1_input_5_10_20_40_length_values (String value){
		System.out.println("value " + value);
		System.out.println("value lenght " + value.length());
		
		FinalCourseProject.openTriviaSite();
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}

	@Test
	public void test_7_question_1_fill_different_answers() {
		test_1_question_1_input();
		
		String answer1 = "Monday";
		String answer2 = "Tuesday";
		String answer3 = "Wednesday";
		String answer4 = "Thursday";
		
		boolean bool = FinalCourseProject.answer_fill(answer1, answer2, answer3, answer4);
		assertEquals(true, bool);
		if (bool) {
			FinalCourseProject.answer_option_1_select();		
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@Test
	public void test_8_question_1_fill_the_same_answers() {
		test_1_question_1_input();
		
		String answer1 = "Monday";
		String answer2 = "Monday";
		String answer3 = "Monday";
		String answer4 = "Monday";
		
		assertEquals(true, FinalCourseProject.answer_fill(answer1, answer2, answer3, answer4));
		FinalCourseProject.answer_option_1_select();
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_9_question_1_fill_all_empty_answers() {
		test_1_question_1_input();
		
		String answer1 = "";
		String answer2 = "";
		String answer3 = "";
		String answer4 = "";
		
		assertEquals(true, FinalCourseProject.answer_fill(answer1, answer2, answer3, answer4));
		FinalCourseProject.answer_option_1_select();
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_10_question_1_fill_long_answer() {
		test_1_question_1_input();
		
		String answer1 = "Monday";
		String answer2 = "Tuesday";
		String answer3 = "Wednesday";
		String answer4 = "I have not the foggiest idea which day of week is today :( ";
		
		assertEquals(true, FinalCourseProject.answer_fill(answer1, answer2, answer3, answer4));
		FinalCourseProject.answer_option_1_select();
		FinalCourseProject.clickBtnNext();
	}
	
	/*
	 *    QUESTION 2
	 */
	
	static String question1 = "What is the first day of the week?";
	static String question2 = "What is the second day of the week?";
	static String question3 = "What is the third day of the week?";
	static String answer1 = "Monday";
	static String answer2 = "Tuesday";
	static String answer3 = "Wednesday";
	static String answer4 = "I have not the foggiest idea";
	
	@Test
	public void test_11_question_2_input () {
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.question_fill_(question2));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_12_question_2_input_with_special_symbol () {
		String value = "What's the day today?";
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_13_question_2_input_number_and_words_together () {
		String value = "12345 abcde 67890 fghjk ?";
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_14_question_2_input_special_symbols_only () {
		String value = "! @ # $ % ^ & :) ?";
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"",
			"W",
			"What is the day today and the month and the year?",
			"What is the day today and the month and the year ?"})
	
	void test_15_question_2_input_0_1_49_50_length_values (String value){
		System.out.println("value " + value);
		System.out.println("value lenght " + value.length());
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"What?",
			"Whats the?",
			"Whats the day today?",
			"Whats the day today and the month today?"})
	
	void test_16_question_2_input_5_10_20_40_length_values (String value){
		System.out.println("value " + value);
		System.out.println("value lenght " + value.length());
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}

	@Test
	public void test_17_question_2_fill_different_answers() {
		String _answer1 = "Monday";
		String _answer2 = "Tuesday";
		String _answer3 = "Wednesday";
		String _answer4 = "Thursday";
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		boolean bool = FinalCourseProject.answer_fill(_answer1, _answer2, _answer3, _answer4);
		assertEquals(true, bool);
		if (bool) {
			FinalCourseProject.answer_option_2_select();		
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@Test
	public void test_18_question_2_fill_the_same_answers() {
		String _answer1 = "Monday";
		String _answer2 = "Monday";
		String _answer3 = "Monday";
		String _answer4 = "Monday";
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.answer_fill(_answer1, _answer2, _answer3, _answer4));
		FinalCourseProject.answer_option_2_select();
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_19_question_2_fill_all_empty_answers() {
		String _answer1 = "";
		String _answer2 = "";
		String _answer3 = "";
		String _answer4 = "";
		
		FinalCourseProject.question_1_full_process(question2, answer1, answer2, answer3, answer4);
		
		assertEquals(true, FinalCourseProject.answer_fill(_answer1, _answer2, _answer3, _answer4));
		FinalCourseProject.answer_option_2_select();
		FinalCourseProject.clickBtnNext();
	}
	
	/*
	 *    QUESTION 3
	 */
	
	private static void questions_1_and_2_over() {
		FinalCourseProject.question_1_full_process(question1, answer1, answer2, answer3, answer4);
		FinalCourseProject.question_2_full_process(question2, answer1, answer2, answer3, answer4);
	}
	
	@Test
	public void test_20_question_3_input () {
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.question_fill_(question3));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_21_question_3_input_with_special_symbol () {
		String value = "What's the day today?";
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_22_question_3_input_number_and_words_together () {
		String value = "12345 abcde 67890 fghjk ?";
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_23_question_3_input_special_symbols_only () {
		String value = "! @ # $ % ^ & :) ?";
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"",
			"W",
			"What is the day today and the month and the year?",
			"What is the day today and the month and the year ?"})
	void test_24_question_3_input_0_1_49_50_length_values (String value){
		System.out.println("value " + value);
		System.out.println("value lenght " + value.length());
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"What?",
			"Whats the?",
			"Whats the day today?",
			"Whats the day today and the month today?"})
	void test_25_question_3_input_5_10_20_40_length_values (String value){
		System.out.println("value " + value);
		System.out.println("value lenght " + value.length());
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.question_fill_(value));
		FinalCourseProject.clickBtnNext();
	}

	@Test
	public void test_26_question_3_fill_different_answers() {
		String _answer1 = "Monday";
		String _answer2 = "Tuesday";
		String _answer3 = "Wednesday";
		String _answer4 = "Thursday";
		
		questions_1_and_2_over();
		
		boolean bool = FinalCourseProject.answer_fill(_answer1, _answer2, _answer3, _answer4);
		assertEquals(true, bool);
		if (bool) {
			FinalCourseProject.answer_option_3_select();		
			FinalCourseProject.clickBtnNext();
		}
	}
	
	@Test
	public void test_27_question_3_fill_the_same_answers() {
		String _answer1 = "Monday";
		String _answer2 = "Monday";
		String _answer3 = "Monday";
		String _answer4 = "Monday";
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.answer_fill(_answer1, _answer2, _answer3, _answer4));
		FinalCourseProject.answer_option_3_select();
	    FinalCourseProject.clickBtnNext();
	}
	
	@Test
	public void test_28_question_3_fill_all_empty_answers() {
		String _answer1 = "";
		String _answer2 = "";
		String _answer3 = "";
		String _answer4 = "";
		
		questions_1_and_2_over();
		
		assertEquals(true, FinalCourseProject.answer_fill(_answer1, _answer2, _answer3, _answer4));
		FinalCourseProject.answer_option_3_select();
	    FinalCourseProject.clickBtnNext();
	}
	
	/*
	 *   QUIZ
	 */
	
	private static void questions_1_and_2_and_3_over() {
		FinalCourseProject.question_1_full_process(question1, answer1, answer2, answer3, answer4);
		FinalCourseProject.question_2_full_process(question2, answer1, answer2, answer3, answer4);
		FinalCourseProject.question_3_full_process(question3, answer1, answer2, answer3, answer4);
	}
	
	@Test
	public void test_28_quiz_enter() {
		questions_1_and_2_and_3_over();
		FinalCourseProject.clickBtnPlay();
	}
	
	@Test
	public void test_29_quiz() {
		FinalCourseProject.quiz_answer_select();
		FinalCourseProject.clickBtnTestNext();
	}
}
