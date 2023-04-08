package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {

    private static final Map<String, List<WebPage>> WEB_PAGES_MAP = new HashMap<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://en.wikipedia.org/wiki/William_Shakespeare", "shakespeare", "To be, or not to be, that is the question: Whether 'tis nobler in the mind to suffer The slings and arrows of outrageous fortune, Or to take arms against a sea of troubles And by opposing end them. To die—to sleep, No more; and by a sleep to say we end The heart-ache and the thousand natural shocks That flesh is heir to: 'tis a consummation Devoutly to be wish'd. To die, to sleep; To sleep, perchance to dream—ay, there's the rub, For in that sleep of death what dreams may come, When we have shuffled off this mortal coil, Must give us pause—there's the respect That makes calamity of so long life.");
        WebPage page2 = new WebPage("https://en.wikipedia.org/wiki/All_Star", "AllStar", "Somebody once told me the world is gonna roll me I ain't the sharpest tool in the shed She was looking kind of dumb with her finger and her thumb In the shape of an \"L\" on her forehead Well the years start coming and they don't stop coming Fed to the rules and I hit the ground running Didn't make sense not to live for fun Your brain gets smart but your head gets dumb So much to do, so much to see So what's wrong with taking the back streets? You'll never know if you don't go You'll never shine if you don't glow Hey now, you're an all-star, get your game on, go play Hey now, you're a rock star, get the show on, get paid And all that glitters is gold Only shooting stars break the mold It's a cool place and they say it gets colder You're bundled up now, wait 'til you get older But the meteor men beg to differ Judging by the hole in the satellite picture The ice we skate is getting pretty thin The water's getting warm so you might as well swim My world's on fire, how about yours? That's the way I like it and I'll never get bored Hey now, you're an all-star, get your game on, go play Hey now, you're a rock star, get the show on, get paid All that glitters is gold Only shooting stars break the mold Hey now, you're an all-star, get your game on, go play Hey now, you're a rock star, get the show, on get paid And all that glitters is gold Only shooting stars Somebody once asked could I spare some change for gas? I need to get myself away from this place I said, \"Yup\" what a concept I could use a little fuel myself And we could all use a little change Well, the years start coming and they don't stop coming Fed to the rules and I hit the ground running Didn't make sense not to live for fun Your brain gets smart but your head gets dumb So much to do, so much to see So what's wrong with taking the back streets? You'll never know if you don't go (go!) You'll never shine if you don't glow Hey now, you're an all-star, get your game on, go play Hey now, you're a rock star, get the show on, get paid And all that glitters is gold Only shooting stars break the mold And all that glitters is gold Only shooting stars break the mold");
        WebPage page3 = new WebPage("https://en.wikipedia.org/wiki/Sports_science", "Sport", "Sports have long been an important part of human culture, with a history that stretches back thousands of years. In recent years, scientists have begun to study the impact of sports on human health and well-being, as well as the psychological and social benefits that sports can provide. One of the most obvious benefits of sports is their impact on physical health. Regular participation in sports can help to improve cardiovascular health, reduce the risk of obesity, and increase overall fitness levels. Athletes who engage in high-intensity sports like running, swimming, or cycling can also benefit from increased endurance, strength, and agility. Beyond the physical benefits, sports can also have significant psychological and social impacts. Studies have shown that participation in sports can improve mental health and well-being, reduce stress and anxiety, and even help to prevent depression. Sports can also provide a sense of belonging and community, particularly for children and young people who may be struggling to find their place in the world. In addition to these individual benefits, sports can also have wider social and cultural impacts. Major sporting events like the Olympics or the World Cup can bring people from all over the world together, promoting understanding and collaboration across cultures. Sports can also be a powerful tool for promoting social justice and equality, particularly when it comes to gender and race. Despite the many benefits of sports, it's important to recognize that there can also be risks and challenges associated with athletic activity. Injuries, particularly in contact sports like football or rugby, are common and can have serious long-term consequences. There can also be social and cultural pressures associated with sports, particularly in highly competitive environments. Overall, however, the benefits of sports are clear. Whether it's through improved physical health, enhanced mental well-being, or increased social connections, sports have the power to enrich our lives in countless ways. As scientists continue to explore the relationship between sports and human health, we can look forward to even greater insights into the role that sports can play in creating a healthier, happier, and more connected world.");
        WebPage page4 = new WebPage("https://en.wikipedia.org/wiki/Video_game", "VideoGames", "Video games have become an increasingly popular form of entertainment in recent years, with millions of people around the world spending hours each day playing games on consoles, computers, and mobile devices. As the popularity of video games continues to grow, scientists are exploring the impact that gaming can have on our physical, cognitive, and social well-being. One of the most obvious impacts of video games is their effect on cognitive function. Studies have shown that playing video games can improve attention, memory, and spatial reasoning skills, particularly in fast-paced action games that require quick decision-making and rapid response times. Gamers have also been shown to have better hand-eye coordination and reaction times than non-gamers, which can translate into real-world benefits in areas like driving or sports. In addition to these cognitive benefits, video games can also have positive social impacts. Multiplayer games, in particular, can provide a sense of community and social connection, allowing players to form relationships with others from around the world. In some cases, video games have even been used as a tool for promoting social justice and raising awareness of important social issues. Despite these benefits, it's important to recognize that video games can also have negative impacts. Excessive gaming can lead to a sedentary lifestyle, which can contribute to obesity and other health problems. There is also concern that violent video games may contribute to aggressive behavior, although the evidence on this issue is mixed. Overall, the impact of video games on human health and well-being is complex and multifaceted. While there are certainly risks associated with excessive gaming, there are also many potential benefits, particularly in terms of cognitive function and social connection. As scientists continue to explore the relationship between video games and human health, it will be important to strike a balance between enjoying this popular form of entertainment and maintaining a healthy lifestyle.");

        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);
        indexWebPage(page4);

        printWebPagesMap();
        
        System.out.println("***********");
        findWebPagesByIndex("TOOL");
        removeWebPage("TOOL", page3.url());

        System.out.println("***********");
        findWebPagesByIndex("TOOL");
    }

    public static void removeWebPage(String index, String url) {
        Optional.ofNullable(WEB_PAGES_MAP.get(index))
                .ifPresentOrElse(
                        webPages -> webPages.removeIf(webPage -> Objects.equals(webPage.url(), url)),
                        () -> System.out.println("No web page found!")
                );
    }

    public static void indexWebPage(WebPage webPage) {
        String[] arrayOfWords = webPage.content()
                .replaceAll("[^\\p{L}\\s]+", "")
                .split("\\s+");

        List<String> strings =
                Arrays.stream(arrayOfWords)
                        .map(String::toUpperCase)
                        .distinct()
                        .toList();

        for (String s : strings) {
            if (WEB_PAGES_MAP.containsKey(s)) {
                WEB_PAGES_MAP.get(s).add(webPage);
            } else {
                WEB_PAGES_MAP.put(s, new ArrayList<>(List.of(webPage)));
            }
        }
    }

    public static void printWebPagesMap() {
        for (var set : WEB_PAGES_MAP.entrySet()) {
            System.out.println(set.getKey() + ":");
            for (WebPage page : set.getValue()) {
                System.out.println("\t" + page);
            }
        }
    }

    public static void findWebPagesByIndex(String index) {
        WEB_PAGES_MAP.get(index).forEach(System.out::println);
    }
}
