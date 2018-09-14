import { DDLManagerPage } from './app.po';

describe('ddlmanager App', () => {
  let page: DDLManagerPage;

  beforeEach(() => {
    page = new DDLManagerPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
