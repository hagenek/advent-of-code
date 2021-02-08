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
    public void Valid_Pwd_Is_Valid()
    {
      var validator = new PasswordValidator();
      Assert.IsTrue(validator.Validate("abc123"));
    }

            [Test]
    public void Invalid_Password_Is_Invalid()
    {
      var validator = new PasswordValidator();
      Assert.IsFalse(validator.Validate("lolol123"));
    }
  }
}