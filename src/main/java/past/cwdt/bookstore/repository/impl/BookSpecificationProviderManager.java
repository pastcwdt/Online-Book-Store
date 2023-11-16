package past.cwdt.bookstore.repository.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import past.cwdt.bookstore.exceptions.SpecificationNotFoundException;
import past.cwdt.bookstore.model.Book;
import past.cwdt.bookstore.repository.SpecificationProvider;
import past.cwdt.bookstore.repository.SpecificationProviderManager;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(()
                        -> new SpecificationNotFoundException("Can't find specification provider"
                        + " by key " + key));
    }
}
