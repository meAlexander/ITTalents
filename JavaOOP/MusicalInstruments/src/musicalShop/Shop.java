package musicalShop;

import instruments.Instrument;
import util.Randomizer;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private double moneyInCash;
    private double moneyFromSell;
    private final HashMap<String, HashMap<String, TreeSet<Instrument>>> allInstrument;
    private final TreeSet<Instrument> soldInstruments;

    public Shop(double moneyInCash) {
        this.moneyInCash = moneyInCash;
        this.moneyFromSell = 0;
        allInstrument = new HashMap<>();
        soldInstruments = new TreeSet<>((e1, e2) -> {
            if(!e1.getName().equals(e2.getName()))
            {
                if(!e1.getType().equals(e2.getType())){
                    return e2.getSold() - e1.getSold();
                }
            }
            return 0;
        });
        generateInstrument();
    }

    public void fillInShop(Instrument e) {
        if (!allInstrument.containsKey(e.getName())) {
            allInstrument.put(e.getName(), new HashMap<>());
        }
        if (!allInstrument.get(e.getName()).containsKey(e.getType())) {
            allInstrument.get(e.getName()).put(e.getType(), new TreeSet<>((e1, e2) -> {
                if (!e1.getName().equals(e2.getName())) {
                    if (!e1.getType().equals(e2.getType())) {
                        return 1;
                    }
                }
                return 0;
            }));
        }
        allInstrument.get(e.getName()).get(e.getType()).add(e);
        moneyInCash += e.getPrice();
    }

    public void generateInstrument() {
        for (int i = 0; i < 50; i++) {
            int type = Randomizer.generateInt(5, 1);
            Instrument instrument;
            switch (type) {
                case 1 -> {
                    int kindElectronic = Randomizer.generateInt(3, 1);
                    switch (kindElectronic) {
                        case 1 -> instrument = new Instrument
                                ("Electronic", "synthesizer", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 2 -> instrument = new Instrument
                                ("Electronic", "bassGuitar", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        default -> instrument = new Instrument
                                ("Electronic", "electricViolin", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                    }
                }
                case 2 -> {
                    int kindKeyboard = Randomizer.generateInt(3, 1);
                    instrument = switch (kindKeyboard) {
                        case 1 -> new Instrument
                                ("Keyboard", "organ", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 2 -> new Instrument
                                ("Keyboard", "piano", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        default -> new Instrument
                                ("Keyboard", "accordion", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                    };
                }
                case 3 -> {
                    int kindPercussion = Randomizer.generateInt(4, 1);
                    instrument = switch (kindPercussion) {
                        case 1 -> new Instrument
                                ("Percussion", "drums", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 2 -> new Instrument
                                ("Percussion", "tarambuka", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 3 -> new Instrument
                                ("Percussion", "drum", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        default -> new Instrument
                                ("Percussion", "tambourine", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                    };
                }
                case 4 -> {
                    int kindSpirit = Randomizer.generateInt(5, 1);
                    instrument = switch (kindSpirit) {
                        case 1 -> new Instrument
                                ("Spirit", "trumpet", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 2 -> new Instrument
                                ("Spirit", "trombone", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 3 -> new Instrument
                                ("Spirit", "tuba", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 4 -> new Instrument
                                ("Spirit", "flute", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        default -> new Instrument
                                ("Spirit", "clarinet", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                    };
                }
                default -> {
                    int kindString = Randomizer.generateInt(6, 1);
                    instrument = switch (kindString) {
                        case 1 -> new Instrument
                                ("String", "violin", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 2 -> new Instrument
                                ("String", "viola", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 3 -> new Instrument
                                ("String", "doubleBass", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 4 -> new Instrument
                                ("String", "harp", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        case 5 -> new Instrument
                                ("String", "guitar", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                        default -> new Instrument
                                ("String", "reed", Randomizer.generateDouble(200, 80), Randomizer.generateInt(20, 10));
                    };
                }
            }
            fillInShop(instrument);
        }
    }

    public void sellInstrument(String name, String type, int quantity) {
        if (allInstrument.containsKey(name)) {
            if (allInstrument.get(name).containsKey(type)) {
                for (Instrument a : allInstrument.get(name).get(type)) {
                    if (a.getName().equals(name) && a.getType().equals(type)) {
                        if (a.getQuantity() >= quantity) {
                            double price = a.getPrice();
                            moneyInCash += price * quantity;
                            moneyFromSell += price * quantity;
                            a.setQuantity(quantity);
                            soldInstruments.add(a);
                            System.out.println("Sold: " + a.getName() + " " + a.getType() + " Quantity: " + quantity);
                        } else {
                            System.out.println("Shop doesn't have this quantity!");
                        }
                    }
                    return;
                }
            }
        }
        System.out.println("Shop doesn't have this instrument!");
    }

    public void acceptInstrument(String name, String type, int quantity) {
        fillInShop(new Instrument(name, type,
                Randomizer.generateDouble(200, 80), quantity));

    }

    public void viewInstrumentsByType() {
        allInstrument.keySet()
                .stream().sorted()
                .forEach(System.out::println);
    }

    public void viewInstrumentsByName() {
        allInstrument.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .forEach(e -> System.out.println(e.values()));
    }

    public void viewInstrumentsByPrice() {
        ArrayList<Instrument> ordered = new ArrayList<>();
        for (HashMap<String, TreeSet<Instrument>> a : allInstrument.values()) {
            for (TreeSet<Instrument> b : a.values()) {
                ordered.addAll(b);
            }
        }
        ordered.sort((e1, e2) -> Double.compare(e1.getPrice(), e2.getPrice()));
        ordered.forEach(System.out::println);
    }

    public void viewAvailableInstruments() {
        allInstrument.forEach((key, value) -> System.out.println(key + " " + value.values()));
    }

    public void viewSoldInstrument() {
        soldInstruments.forEach(System.out::println);
    }

    public void viewMoneyFromSell() {
        System.out.println("Money in cash: " + this.moneyInCash);
        System.out.println("Money from sold instruments: " + this.moneyFromSell);
    }

    public void mostSoldInstruments() {
        soldInstruments.stream()
                .collect(Collectors.groupingBy(
                        Instrument::getSold,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .lastEntry()
                .getValue()
                .forEach(System.out::println);
    }

    public void mostUnsoldInstrument(){
        allInstrument.values()
                .stream()
                .map(HashMap::values)
                .flatMap(e->e.stream()
                        .flatMap(Collection::stream))
                .collect(Collectors.groupingBy(
                        Instrument::getSold,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .firstEntry()
                .getValue()
                .forEach(System.out::println);
    }

    public void mostSoldInstrumentByType(){
        TreeMap<Instrument, Integer> count = new TreeMap<>((e1, e2) ->{
            if(!e1.getName().equals(e2.getName())) {
                 return e1.getSold() - e2.getSold();
            }
            return 0;
        });
        for(Instrument a : soldInstruments){
            if (!count.containsKey(a)) {
                count.put(a, a.getSold());
                continue;
            }
            count.put(a, count.get(a) + a.getSold());
        }
        count.entrySet()
                .forEach(e-> System.out.println(e.getKey().getName() + "=" + e.getValue()));
    }
}