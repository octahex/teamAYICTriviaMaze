package cscd350.ayic.triviamaze;

import java.util.Random;

import cscd350.ayic.utility.DataBase;

public class MultipleAnswersBehavior implements QuestionBehavior
{

	private DataBase _db;
	private int _id;
	
	public MultipleAnswersBehavior(DataBase db, int id)
	{
		_db = db;
		_id = id;
	}

	@Override
	public String getQuestion()
	{
		return "Who's that Pokemon?";
	}

	@Override
	public String getCorrectAnswer()
	{
		return _db.retrieveA(_id);
	}

	@Override
	public String[] getFakeAnswers()
	{
		Random gen = new Random();
		String[] fake = new String[3];
		int temp;
		for(int i=0; i<3; i++)
		{
			temp = gen.nextInt(151)+1;
			// TODO check for duplicates
			fake[i] = _db.retrieveA(temp);
		}
		
		return fake;
	}
}
