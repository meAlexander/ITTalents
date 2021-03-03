package json;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        try (FileReader file1 = new FileReader("test.json");
             FileReader file2 = new FileReader("test2.json")
             )
        {
            Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
            JsonObject[] clients = gson1.fromJson(file1, JsonObject[].class);
            file2.close();

            List<Client> clientList = new ArrayList<>();

            for (JsonObject object : clients) {
                Client cl = gson1.fromJson(object.get("client"), Client.class);
                clientList.add(cl);
                System.out.println(cl);
            }
            Client client = new Client("Dimitar", 45, new Child("Mitko", 12));
            Client client2 = new Client("Koceto", 66, new Child("Koko", 32));
            clientList.add(client);
            clientList.add(client2);

            FileWriter file3 = new FileWriter("test2.json");
            gson1.toJson(clientList, file3);
            file3.flush();
            file3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}