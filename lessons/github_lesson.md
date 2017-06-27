## Git and GitHub

### What is Version Control?

Where do we store our code? If you store all your code locally (on your own machine) what happens if your computer crashes? How will you share the code you've written with other people on your team? E-mailing code snippets back and forth might work, but still doesn't solve the problem of where the code lives. What does solve this problem? Version control.

Version control is software that (in one way or another) keeps track of changes you've made to your code and storing that code. Version control is linked into the magic of the interwebs to store our code in "the cloud" so that if we lose our local files, we can just get them off the internet.

There are several different version control systems. CVS, SVN, and Git are all examples. We will be using Git.

### Git/Hub

First, a terminology clarification: Git is the version control software we will be using. GitHub is just a website that allows us to store Git repositories ("repos"). Git was created by Linus Torvalds in 2005.

![Linus](https://imgs.xkcd.com/comics/open_source.png)

Git was an attempt to fix some of the problems with previous version control software (VCS) such as Concurrent Versions System (CVS - good thing there's no way these acronyms could ever be confused).

### Installing, Setup, Creating a GitHub account

#### Create An Account

You will need to create an account with GitHub. Keep in mind that GitHub may eventually become part of your professional resumé - you can use it to showcase projects you've worked on and show it to potential employers (down the road). Go to github.com and sign up for an account if you do not already have one. They will also walk you through setting up your first repo, (again if you haven't already). Additionally, there is a "getting started with git and github" [tutorial](https://try.github.io) that I'd recommend in addition to this lesson.

Signing up for an account is free, and you can have as many **public** repositories as you want to. A repo that's public is pretty much visible to anyone browsing the web. This encourages people to post their code publicly so that others can use it, see it, or learn from it. This is called "open source". Private repositories cost money and are typically used by companies to keep their code private from competitors.

1. **Install Git** - you can download Git [here](https://git-scm.com/download/win). Install the program and accept all defaults.
2. **Open the Terminal** - The quickest way to open the command prompt, or terminal, is to press the Windows key + R, and type `cmd` and hit run. This will bring you to a black screen with machiney font text where you can type commands in to your computer. If you need help getting started with the terminal, please reach out to me or, if you're feeling adventurous, you can seek out an online tutorial.
3. **Check Git Version** - In the terminal, type `git --version`. You should see something back like `git version 2.10.1`. Don't worry if the numbers are different, but if you get something back like "command not found", your installation wasn't successful.

### Using Git from the Command Line

There are dozens of commands available in git and some of them are fairly complicated in what they do. All git commands look like this: `git <command> <arguments>`, where "command" is the action that we want to take and "arguments" tells that command what we want it to do specifically (i.e. which file to add). Here are the most basic commands that you will find yourself using a lot.

#### init

The `init` command initializes (creates) a Git repo at the current location. This is how you will create your repository locally. GitHub has instructions that will guide you through this process.

Example: `git init`

#### status

This command will tell you the current status: what branch you are on (discussed below) as well as listing any changes: files that haven't been added yet, files that have been added but not pushed, etc.

Example: `git status`

#### add/rm

The "add" command tells git that we want to add the given files/changes to the current branch and keep track of them. You can use `git add <filename>` replacing the name of the file in question, or `git add .` will add all files. `rm` will remove files from the current branch.

Example: `git add Car.java`

#### commit

Commit takes all the files/changes that have been added and bundles them up together. You can think of commit as similar to saving your progress in a game. It takes a snapshot of where you are currently.

Similar to saving a game, you should **use commit frequently**. Every time you develop a new feature, that should be its own commit. The easiest way to make commits is `git commit -m <message>`, where <message> is a short description of the changes you have made.

Example: `git commit -m "Added autonomous code to drive straight"`

#### push

The push command takes all of your commits and "pushes" them up to your GitHub repository. Think of your GitHub repo as existing above you in the cloud. Raise your hands up in the air and push - that's sending your code to the cloud. If your repo hasn't been initialized yet (it doesn't know where your online repo is), git will prompt you.

Example: `git push`

#### pull

The pull command goes to your online GitHub repository and "pulls" any changes down. Again, think of the repo as above you and imagine pulling something down towards you.

#### Basic Workflow (add, commit, push)

Your basic "flow" will be to right some code, saving those changes as appropriate. Then you will need to add the changes, commit them, and push them up to the repo.

`git add .`

`git commit -m "Here are changes!"`

`git push`

### Branching

Often when programming (read: in actual programming, ALL THE TIME), you want to be able to make some experimental changes to your code that you aren't sure will work. Because of this, you want to keep a separate copy of your code that you know works. In version control, this is accomplished by **branching**.

All Git repos have a "master" branch by default. You can think of this as your "main" or "stable" branch. In smaller simpler projects, it's OK to make changes to master - but in any larger project you should use branches to add new features.

For example, let's say you are four weeks in to build season. You have an existing version of your code that the team is using to test-drive the robot. **This version (master) should not be changed until you are certain that the changes will work correctly.** Your team asks you to develop new autonomous code to accomplish a game objective. Your workflow would be:

1. Create a new branch called `new-auto-code` (or something more descriptive).
2. Check out that branch (i.e. switch to work on it)
3. Write your code on the branch
4. Test code on the branch. If/when tests are successful, **merge** that branch into `master`.

### Intermediate Git Commands

Now that we've discuss the concept of branching, let's go over some slightly more complex Git commands.

#### clone

Clone allows you to create a local copy of a repository. You provide it with the URL of the repository you want to copy.

Example: `git clone https://github.com/gradyrobotics/java-learning.git`

#### branch

Creates a new branch (as discussed above) you will need to provide the name of the branch. The name should be descriptive, providing information about what features the branch is working on.

Example: `git branch auton-drive-straight`

#### checkout

Checkout allows you to switch back and forth between branches. You will need to provide it the name of the branch you want to switch to. (If you have changes that haven't been "staged for commit" git will stop and give you a warning. In effect, it wants you to specify whether you want to save those changes to the current branch, discard them, or do something else)

Example: `git checkout master` `git checkout auton-drive-straight`
