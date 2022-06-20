void function footer() {
    const html = `
    <footer id="footer" class="site-footer bg-dark text-light js-footer" role="contentinfo">
        <div class="site-footer--container">
            <nav class="site-footer--nav">
                    <div class="site-footer--col">
                        <h5 class="-title"><a href="/">Stack Overflow KATA</a></h5>
                        <ul class="-list js-primary-footer-links">
                                    <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 2 })" href="/tour">Тур</a></li>
                        </ul>
                    </div>
                <div class="site-footer--col">
                    <h5 class="-title"><a class="js-gps-track" data-gps-track="footer.click({ location: 1, link: 1 })">Компания</a></h5>
                    <ul class="-list">
                                <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 1 })" href="https://kata.academy/">О компании</a></li>
                                <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 1 })" href="https://kata.academy/contacts">Контакты</a></li>
                    </ul>
                
                </div>
                <div class="site-footer--col site-footer--categories-nav">
                    <div>
                        <h5 class="-title"><a href="https://kata.academy/community" data-gps-track="footer.click({ location: 1, link: 30 })">Коммьюнити</a></h5>
                        <ul class="-list">
                            <li>
                                <a href="https://kata.academy/live" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Эфиры
                                </a>
                            </li>
                            <li>
                                <a href="https://kata.academy/article" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Статьи
                                </a>
                            </li>
                            <li>
                                <a href="https://kata.academy/history" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Истории выпускников
                                </a>
                            </li>

                            <li class="mt16 md:mt0">
                                <a href="https://kata.academy/life" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                   Мероприятия
                                </a>
                            </li>

                           
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="site-footer--copyright fs-fine md:mt24">
                <ul class="-list -social md:mb8">
                    <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link:4 })" href="https://kata.academy/">Сайт</a></li>
                    <li><a href="https://vk.com/kataacademy" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 31 })">ВКонтакте</a></li>
                    <li><a href="https://www.youtube.com/channel/UCsmPQu0jnkNugG6WXmxC6kw/featured" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 32 })">YouTube</a></li>
                    <li><a href="https://t.me/kata_academy" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 33 })">Telegram</a></li>
                    <li><a href="https://api.whatsapp.com/send/?phone=79959968596&text=%D0%9F%D1%80%D0%B8%D0%B2%D0%B5%D1%82%21+%D0%9E%D1%82%D0%BF%D1%80%D0%B0%D0%B2%D1%8C%2C+%D0%BF%D0%BE%D0%B6%D0%B0%D0%BB%D1%83%D0%B9%D1%81%D1%82%D0%B0%2C+%D0%BD%D0%B0%D0%BC+%D1%8D%D1%82%D0%BE+%D1%81%D0%BE%D0%BE%D0%B1%D1%89%D0%B5%D0%BD%D0%B8%D0%B5+%D1%81+%D0%BD%D0%BE%D0%BC%D0%B5%D1%80%D0%BE%D0%BC+285728.+%D0%9C%D1%8B+%D0%B7%D0%B0%D1%80%D0%B5%D0%B3%D0%B8%D1%81%D1%82%D1%80%D0%B8%D1%80%D1%83%D0%B5%D0%BC+%D1%82%D0%B2%D0%BE%D0%B5+%D0%BE%D0%B1%D1%80%D0%B0%D1%89%D0%B5%D0%BD%D0%B8%D0%B5%2C+%D0%B8+%D0%B2+%D1%81%D0%BB%D0%B5%D0%B4%D1%83%D1%8E%D1%89%D0%B5%D0%BC+%D1%81%D0%BE%D0%BE%D0%B1%D1%89%D0%B5%D0%BD%D0%B8%D0%B8+%D1%82%D1%8B+%D0%BC%D0%BE%D0%B6%D0%B5%D1%88%D1%8C+%D0%B7%D0%B0%D0%B4%D0%B0%D1%82%D1%8C+%D1%81%D0%B2%D0%BE%D0%B9+%D0%B2%D0%BE%D0%BF%D1%80%D0%BE%D1%81%21+%D0%A2%D0%B5%D0%B1%D0%B5+%D1%81%D0%BA%D0%BE%D1%80%D0%BE+%D0%BE%D1%82%D0%B2%D0%B5%D1%82%D0%B8%D1%82+%D0%BF%D0%B5%D1%80%D0%B2%D1%8B%D0%B9+%D1%81%D0%B2%D0%BE%D0%B1%D0%BE%D0%B4%D0%BD%D1%8B%D0%B9+%D0%BA%D0%BE%D0%BE%D1%80%D0%B4%D0%B8%D0%BD%D0%B0%D1%82%D0%BE%D1%80+%3D%29&app_absent=0" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 36 })">WhatsApp</a></li>
                </ul>

                <p class="md:mb0">
Site design / logo © 2022 ....<a href="/">...</a>.                    <span id="svnrev">....</span>
                </p>
            </div>
        </div>

    </footer>
    
 
  `;
    document.body.insertAdjacentHTML('beforeend', html);
}();


