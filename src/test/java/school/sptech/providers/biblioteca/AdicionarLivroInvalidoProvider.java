package school.sptech.providers.biblioteca;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import school.sptech.factory.LivroFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AdicionarLivroInvalidoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Object l1 = LivroFactory.build("O Senhor dos Anéis", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object l2 = LivroFactory.build("Harry Potter e a Pedra Filosofal", "J. K. Rowling", LocalDate.parse("1997-06-26"), new ArrayList<>());
        Object l3 = LivroFactory.build("O Pequeno Príncipe", "Antoine de Saint-Exupéry", LocalDate.parse("1943-04-06"), new ArrayList<>());
        Object l4 = LivroFactory.build("Dom Quixote", "Miguel de Cervantes", LocalDate.parse("1605-01-16"), new ArrayList<>());
        Object l5 = LivroFactory.build("1984", "George Orwell", LocalDate.parse("1949-06-08"), new ArrayList<>());

        Object li1 = LivroFactory.build("", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object li2 = LivroFactory.build(null, "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object li3 = LivroFactory.build("O Senhor dos Anéis", null, LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object li4 = LivroFactory.build("O Senhor dos Anéis", " ", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object li5 = LivroFactory.build("O Senhor dos Anéis", "J. K. Rowling", null, new ArrayList<>());
        Object li6 = LivroFactory.build("O Senhor dos Anéis", "", LocalDate.parse("1954-07-29"), new ArrayList<>());
        Object li7 = LivroFactory.build(" ", "J. R. R. Tolkien", LocalDate.parse("1954-07-29"), new ArrayList<>());

        return Stream.of(
                Arguments.of("Biblioteca Nacional", List.of(), null, List.of()),
                Arguments.of("Biblioteca Nacional", List.of(l1), li1, List.of(l1)),
                Arguments.of("Biblioteca Nacional", List.of(l1), li2, List.of(l1)),
                Arguments.of("Biblioteca Nacional", List.of(l5, l4), li3, List.of(l5, l4)),
                Arguments.of("Biblioteca Nacional", List.of(l1, l3, l5, l2), li4, List.of(l1, l3, l5, l2)),
                Arguments.of("Biblioteca Nacional", List.of(l3), li5, List.of(l3)),
                Arguments.of("Biblioteca Nacional", List.of(l5, l4), li6, List.of(l5, l4)),
                Arguments.of("Biblioteca Nacional", List.of(l1, l3, l5, l2), li7, List.of(l1, l3, l5, l2))
        );
    }
}
