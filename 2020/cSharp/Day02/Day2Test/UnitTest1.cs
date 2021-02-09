using NUnit.Framework;
using Day02Code;

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
      var result = validator.IsValid(password, 1);
      Assert.IsTrue(result);
    }

    [Test]
    [TestCase("1-3 b: cdefg")]
    public void Invalid_Password_Is_Invalid(string password)
    {
        var validator = new PasswordValidator();
        var result = validator.IsValid(password, 1);
        Assert.IsFalse(result);
    }
    // Policy number two tests
    [Test]
    [TestCase("1-3 b: bdffg")]
    [TestCase("3-5 e: bdefqe")]
    public void Valid_Password_Is_Valid(string password)
    {
        var validator = new PasswordValidator();
        var result = validator.IsValid(password, 2);
        Assert.IsTrue(result);
    }
  }
}