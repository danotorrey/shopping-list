import * as React from 'react';

interface Shopping {
    id: number;
    name: string;
}

interface ShoppingListState {
    items: Array<Shopping>;
    isLoading: boolean;
}

class ShoppingList extends React.Component<{}, ShoppingListState> {

    constructor(props: {}) {
        super(props);

        this.state = {
            items: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/allItems')
            .then(response => response.json())
            .then(data => this.setState({items: data, isLoading: false}));
    }

    render() {
        const {items, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Shopping List</h2>
                {items.map((item: Shopping) =>
                    <div key={item.id}>
                        {item.name}
                    </div>
                )}
            </div>
        );
    }
}

export default ShoppingList;