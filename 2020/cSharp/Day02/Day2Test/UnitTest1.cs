using NUnit.Framework;

namespace Day2Test
{
  public class Tests
  {
    [SetUp]
    public void Setup()
    {
    }
        
    [Test]
    [TestCase("1-3 a: abcde")]
    [TestCase("2-9 c: ccccccccc")]
    [TestCase("4-5 b: abbbcdbbe")]
    [TestCase("2-9 c: ccccccccc")]
    public void Valid_Pwd_Is_Valid(string password)
    {
      var validator = new PasswordValidator();
      var result = validator.Validate(password);
      Assert.IsTrue(result);
    }

    [Test]
    [TestCase("1-3 b: cdefg")]
    public void Invalid_Password_Is_Invalid(string password)
    {
        var validator = new PasswordValidator();
        var result = validator.Validate(password);
        Assert.IsFalse(result);
    }

    [Test]
    [TestCase("1-3 b: bdbfg")]
    [TestCase("3-5 e: bdefe")]
    public void Valid_Password_Is_Valid(string password)
    {
        var validator = new PasswordValidator();
        var result = validator.Validate2(password);
        Assert.IsTrue(result);
    }
  }
}