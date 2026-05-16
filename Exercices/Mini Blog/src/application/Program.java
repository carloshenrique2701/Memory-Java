package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Comments;
import entities.Posts;

public class Program {
	
	private static Scanner sc = new Scanner(System.in);
	static List<Posts> posts = new ArrayList<>();

	public static void main(String[] args) {

		Date d1 = new Date();
		Posts newPost = new Posts(d1, "Hotel California", "The most Beautifull music", 0);
		posts.add(newPost);
	
		newPost = new Posts(d1, "Livin'on a player", "The most Beautifull music", 10);
		posts.add(newPost);
		
		newPost = new Posts(d1, "Dream on", "Dream baby, just dream...", 222);
		posts.add(newPost);
		
		System.out.println("============================POSTS============================\n");
		listAllPosts();
		
	}

	private static void menu() {

		System.out.println("============================MENU============================\n");
		
		System.out.println("1. View all posts;\n"
						 + "2. View a especific post;\n"
						 + "3. Create post;\n"
						 + "4. Quit;");
		System.out.println("\nChoose one:");
		int option = sc.nextInt();
		
		switch (option) {
			case 1: {
				listAllPosts();
			}
			case 2: {
				findPost();
				menu();
			} 
			case 3: {
				createPost();
			}
			case 4: {
				System.out.println("Leaving...");
				return;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
		}
		
	}

	private static void createPost() {
		
		Date dateNow = new Date();
		sc.nextLine();
		System.out.print("Enter a title: ");
		String title = sc.nextLine();
		
		System.out.println("Enter a post's body: ");
		String body = sc.nextLine();
		
		Posts newPost = new Posts(dateNow, title, body, 0);
		
		posts.add(newPost);
		menu();
	}

	private static void findPost() {

		boolean loop = true;
		int idx = 0;
		
		while (loop) {
			System.out.print("What is the index of the post? (Enter 0 to go back) ");
			idx = sc.nextInt();
			
			if (idx > posts.size() && idx < 0) {
				System.out.println("\nIndex inválid\n");
			} else if (idx == 0) {
				loop = false;
				return;
			} else {
				loop = false;
			}
		}
		
		findPost(idx);
		
	}

	private static void findPost(int idx) {
		
		System.out.println("============================POST " + idx +"============================\n");
		
		System.out.println(posts.get(idx - 1));
		
		System.out.println("1. 🤍 Like;\n"
						 + "2. 💔​ Remove Like;\n"
						 + "3. Create comment;\n"
						 + "4. Quit;");
		System.out.println("\nChoose one:");
		int option = sc.nextInt();
		
		switch (option) {
			case 1: {
				addLike(idx);
			}
			case 2: {
				removeLike(idx);
			} 
			case 3: {
				createComment(idx);
			}
			case 4: {
				System.out.println("Returning to menu...\n");
				menu();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
		}
		
	}


	private static void createComment(int idx) {
		sc.nextLine();
		System.out.println("Enter new comment: \n");
		Comments newComment = new Comments(sc.nextLine());
		
		posts.get(idx - 1).addComment(newComment);
		
		findPost(idx);
		
	}

	private static void removeLike(int idx) {
		
		if(posts.get(idx - 1).getLikes() >= 0) {
			posts.get(idx - 1).removeLikes(1);
			findPost(idx);
		} else {
			System.out.println("Like is 0.");
			findPost(idx);
		}
		
	}

	private static void addLike(int idx) {
		
		posts.get(idx - 1).addLikes(1);
		findPost(idx);
		
	}

	private static void listAllPosts() {

		if(posts.size() == 0) {
			System.out.println("Nothing here yet.\n");
		} else {
			for (int i = 1; i <= posts.size(); i++) {
				System.out.println("\n#"+ i + "\n" + posts.get(i - 1));
			}
		}
		
		menu();

	}

}
