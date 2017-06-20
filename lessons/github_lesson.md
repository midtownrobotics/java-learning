## Git and GitHub

UNFINISHED

Make sure all students have a github account and can create a repo and push to a repo
Github username - be professional

How to use git
  Commit frequently
  Discuss branching and Pull Requests

### What is Version Control?

Where do we store our code? If you store all your code locally (on your own machine) what happens if your computer crashes? How will you share the code you've written with other people on your team? E-mailing code snippets back and forth might work, but still doesn't solve the problem of where the code lives. What does solve this problem? Version control.

Version control is software that (in one way or another) keeps track of changes you've made to your code and storing that code. Version control is linked into the magic of the interwebs to store our code in "the cloud" so that if we lose our local files, we can just get them off the internet.

There are several different version control systems. CVS, SVN, and Git are all examples. We will be using Git.

### Git/Hub

First, a terminology clarification: Git is the version control software we will be using. Github is just a website that allows us to store Git repositories ("repos"). Git was created by Linus Torvalds in 2005.

![Linus](https://imgs.xkcd.com/comics/open_source.png)

Git was an attempt to fix some of the problems with previous version control software (VCS) such as Concurrent Versions System (CVS - good thing there's no way these acronyms could ever be confused).

### Installing, Setup, Creating a GitHub account

### Using Git from the Command Line

### Basic Git Commands

There are dozens of commands available in git and some of them are fairly complicated in what they do. Here are the most basic commands that you will find yourself using a lot.

#### init

The `init` command initializes (creates) a Git repo at the current location. This is how you will create your repository locally. GitHub has instructions that will guide you through this process.

#### status

This command will tell you the current status: what branch you are on (discussed below) as well as listing any changes: files that haven't been added yet, files that have been added but not pushed, etc.

#### add/rm

The "add" command tells git that we want to add the given files/changes to the current branch and keep track of them. You can use `git add <filename>` replacing the name of the file in question, or `git add .` will add all files. `rm` will remove files from the current branch.

#### commit

Commit takes all the files/changes that have been added and bundles them up together. You can think of commit as similar to saving your progress in a game. It takes a snapshot of where you are currently.

Similar to saving a game, you should **use commit frequently**. Every time you develop a new feature, that should be its own commit. The easiest way to make commits is `git commit -m <message>`, where <message> is a short description of the changes you have made. For example:

`git commit -m "Added autonomous code to drive straight"`

#### push

The push command takes all of your commits and "pushes" them up to your GitHub repository. Think of your GitHub repo as existing above you in the cloud. Raise your hands up in the air and push - that's sending your code to the cloud. If your repo hasn't been initialized yet (it doesn't know where your online repo is), git will prompt you.

#### pull

The pull command goes to your online GitHub repository and "pulls" any changes down. Again, think of the repo as above you and imagine pulling something down towards you.

#### Basic Workflow (add, commit, push)

Your basic "flow" will be to right some code, saving those changes as appropriate. Then you will need to add the changes, commit them, and push them up to the repo.

`git add .
git commit -m "Here are changes!"
git push`

### Branching

Often when programming (read: in actual programming, ALL THE TIME), you want to be able to make some experimental changes to your code that you aren't sure will work. Because of this, you want to keep a separate copy of your code that you know works. In version control, this is accomplished by **branching**.

All Git repos have a "master" branch by default. You can think of this as your "main" or "stable" branch. In smaller simpler projects, it's OK to make changes to master - but in any larger project you should use branches to add new features.

For example, let's say you are four weeks in to build season. You have an existing version of your code that the team is using to test-drive the robot. **This version should not be changed until you are certain that the changes will work correctly.** Your team asks you to develop new autonomous code to accomplish a game objective. Your workflow would be:

1. Create a new branch called `new-auto-code` (or something more descriptive).
2. Check out that branch (i.e. switch to work on it)
3. Write your code on the branch
4. Test code on the branch. If/when tests are successful, **merge** that branch into `master`.

### Intermediate Git Commands

Now that we've discuss the concept of branching, let's go over some slightly more complex Git commands.

#### clone

#### branch

#### checkout
